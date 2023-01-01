package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class if_incomeSchedule_greedy {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] num = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[][] num) {
		Arrays.sort(num, ((o1, o2) -> (o1[0] == o2[0]) ? o2[1] - o1[1] : o2[0] - o1[0]));

		int ret = 0;
		boolean[] visited = new boolean[10001];
		for (int i = 0; i < n; i++) {
			for (int j = num[i][1]; j >= 1; j--) {
				if (!visited[j]) {
					visited[j] = true;
					ret += num[i][0];
					break;
				}
			}
		}

		return ret;
	}

}
