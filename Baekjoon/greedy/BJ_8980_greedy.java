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
		Arrays.sort(bus, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		int ret = 0;
		int[] boxs = new int[n + 1];

		for (int[] busStop : bus) {
			int start = busStop[0];
			int end = busStop[1];
			int box = busStop[2];
			int max = 0;
			boolean isLoad = true;

			for (int i = start; i < end; i++) {
				if (boxs[i] >= c) {
					isLoad = false;
					break;
				}
				max = Math.max(max, boxs[i]);
			}

			if (isLoad) {
				int unLoad = c - max;
				if (unLoad > box) {
					unLoad = box;
				}
				ret += unLoad;

				for (int i = start; i < end; i++) {
					boxs[i] += unLoad;
				}
			}
		}

		return ret;
	}

}
