package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_8980_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[][] bus = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			bus[i][0] = Integer.parseInt(st.nextToken());
			bus[i][1] = Integer.parseInt(st.nextToken());
			bus[i][2] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, c, m, bus));
	}

	public static int solution(int n, int c, int m, int[][] bus) {
		Arrays.sort(bus, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		Map<Integer, int[]> map = new HashMap<>();
		int weight = 0;
		int busStop = 1;
		int ret = 0;
		while (busStop <= n) {
			for (int i = 0; i < m; i++) {
				int max = Integer.MIN_VALUE;
				int maxBusStop = Integer.MAX_VALUE;
				for (int key : map.keySet()) {
					if(busStop == map.get(key)[0]) {
						ret += map.get(key)[1];
						weight -= map.get(key)[1];
					}
				}

				if (bus[i][0] == busStop) {
					if (weight + bus[i][2] <= c) {
						map.put(busStop, new int[]{bus[i][1], bus[i][2]});
					} else if(c - weight > 0){
						map.put(busStop, new int[]{bus[i][1], c - weight});
					}
					if(weight == c) break;
				}
			}
			busStop++;
		}

		return 0;
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				2
//				,1
//				,new int[][]{{5,10}, {100,100}}
//				,new Integer[]{11}
//		)).isEqualTo(
//				10
//		);
//	}
//
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				3
//				,2
//				,new int[][]{{1,65}, {5,23}, {2,99}}
//				,new Integer[]{10,2}
//		)).isEqualTo(
//				164
//		);
//	}
	
}
