package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1946_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] person = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				person[i][0] = Integer.parseInt(st.nextToken());
				person[i][1] = Integer.parseInt(st.nextToken());
			}

			System.out.println(solution(n, person));
		}
	}

	public static int solution(int n, int[][] person) {
		Stack<int[]> stack = new Stack<>();
		Arrays.sort(person, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		for (int[] p : person) {
			if (stack.isEmpty()) {
				stack.add(p);
			} else if(p[0] < stack.peek()[0] || p[1] < stack.peek()[1]) {
				stack.add(p);
			}
		}

		return stack.size();
	}
	
}
