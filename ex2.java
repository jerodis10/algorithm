import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class ex2 {

	char[][] map;
	ArrayList<Integer>[] graph;
	boolean[] visited;
//	Map<Integer, Set<String>> hashMap;
	Map<Integer, List<String>> hashMap;

	public int solution(String[] subway, int start, int end) {
		int answer = 0;
//		map = new char[subway.length][subway[0].length()];
//		for(int i=0; i<subway.length;i++){
//			map[i] = subway[i].toCharArray();
//		}

		hashMap = new HashMap<>();
		int max = 0;
		for(int i=0; i<subway.length;i++){
			String[] arr = subway[i].split(" ");
			List<String> list = new ArrayList<>(List.of(arr));
			hashMap.put(i, list);
//			Set<String> set = new HashSet<>(List.of(arr));
//			hashMap.put(i, set);
//			max = Math.max(max, list.size());
		}

		graph = new ArrayList[subway.length];
		visited = new boolean[subway.length];
		int[] dist = new int[subway.length];

		for(int i=0; i<subway.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int key : hashMap.keySet()) {
			for(String str : hashMap.get(key)) {
				for (int key2 : hashMap.keySet()) {
					if (key != key2) {
						if (hashMap.get(key2).contains(str)) {
							if(!graph[key].contains(key2))
								graph[key].add(key2);
							if(!graph[key2].contains(key))
								graph[key2].add(key);
						}
					}
				}
			}
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(start-1);
		visited[start-1] = true;
		dist[start-1] = 0;

		while (!q.isEmpty()) {
			int s = q.poll();

			for (int e : graph[s]) {
				if (!visited[e]) {
					q.add(e);
					visited[e] = true;
					dist[e] = dist[s] + 1;
				}
			}
		}

		int result = 0;
		for (int key : hashMap.keySet()) {
			if (key != start-1 && hashMap.get(key).contains(Integer.toString(end))) {
				result = key;
			}
		}

		return dist[result];
	}


//	테스트 1b
//	입력값 〉
//			["1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"], 1, 9
//	기댓값 〉
//			1
//	실행 결과 〉
//	실행한 결괏값 0이 기댓값 1과 다릅니다.
//	테스트 2
//	입력값 〉
//			["1 2 3 4 5 6 7 8 9 10", "2 8"], 1, 10
//	기댓값 〉
//			0
//	실행 결과 〉
//	테스트를 통과하였습니다.
//	테스트 3
//	입력값 〉
//			["0 1 2 3 4", "1 12 13 14"], 2, 12
//	기댓값 〉
//			1
//	실행 결과 〉
//	실행한 결괏값 0이 기댓값 1과 다릅니다.



	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[]{"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"}
				,1
				,9
		)).isEqualTo(1);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[]{"0 1 2 3 4", "1 12 13 14"}
				,1
				,10
		)).isEqualTo(0);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new String[]{"0 1 2 3 4", "1 12 13 14"}
				,2
				,12
		)).isEqualTo(1);
	}



}
