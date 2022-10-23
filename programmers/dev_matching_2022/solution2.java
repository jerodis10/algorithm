package programmers.dev_matching_2022;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class solution2 {

	boolean[][] visited;
	int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
	Map<String, Integer> hash;
	Map<String, Integer> hash2;

	public int solution(String[] maps) {
		int answer = 0;
		visited = new boolean[maps.length][maps[0].length()];
		hash2 = new HashMap<>();

		for(int i=0; i<maps.length; i++){
			for(int j=0; j<maps[0].length(); j++){
				if(!visited[i][j]){
					hash = new HashMap<>();
					dfs(i,j, maps);
					checkCover(i,j);
				}
			}
		}

		for(String key : hash2.keySet()) {
			answer = Math.max(answer, hash2.get(key));
		}

		return answer;
	}

	public void dfs(int y, int x, String[] maps) {
		if(maps[y].charAt(x) == '.') return;

		visited[y][x] = true;
		String key = maps[y].substring(x, x+1);
		if(hash.containsKey(key)){
			int n = hash.get(key);
			hash.replace(key, n++);
		} else {
			hash.put(key, 1);
		}

		for(int i=0; i<4; i++){
			int nextY = y + dir[i][0];
			int nextX = x = dir[i][1];

			if(nextY >= maps.length || nextY < 0 || nextX >= maps[0].length() || nextX < 0) continue;
			if(!visited[nextY][nextX]){
				dfs(nextY, nextX, maps);
			}
		}
	}

	public String checkCover(int y, int x) {
		int maxN = 0;
		String maxKey = "";
		for(String key : hash.keySet()) {
			if(maxN < hash.get(key)){
				maxN = hash.get(key);
				maxKey = key;
			}
		}

		for(String key : hash.keySet()) {
			if(key.equals(maxKey)) continue;

			if(maxN > hash.get(key)){
				if(hash2.containsKey(maxKey)){
					hash2.replace(key, maxN + hash2.get(key));
				} else {
					hash2.put(maxKey, maxN + hash2.get(key));
				}

			}
		}

		return maxKey;
	}




	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[] {"XY..", "YX..", "..YX", ".AXY"}
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase() {
		String s =  "abcd";
		System.out.println(s.substring(2,3));


//		char a = 'b';
//		System.out.println(a - 'a');
//		System.out.println('a' - 0);

//		String s = "abcd123";
//		System.out.println(s.matches("^[a-z]{3,6}[0-9]{0,6}$"));
//		s.matches("^[a-z]{3}[0-9]{3}$");
	}

//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				9,
//				new int[] {0,0,1,2,0,1,1,1,1,1,1}
//		)).isEqualTo(
//				new int[] {1,1,2,0,1,2,2,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				10,
//				new int[] {0,0,0,0,0,0,0,0,3,4,3}
//		)).isEqualTo(
//				new int[] {1,1,1,1,1,1,1,1,0,0,2}
//		);
//	}
}
