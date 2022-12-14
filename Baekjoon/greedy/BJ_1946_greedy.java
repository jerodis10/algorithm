package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1946_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] person = new int[n][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				person[i][0] = Integer.parseInt(st.nextToken());
				person[i][1] = Integer.parseInt(st.nextToken());
			}

			System.out.println(solution(n, person));
		}
	}

	public static int solution(int n, int[][] person) {

	}
	
}
