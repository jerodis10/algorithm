package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class if_findFriend_greedy {
	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] friend = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			friend[i][0] = Integer.parseInt(st.nextToken());
			friend[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());

		System.out.println(solution(n, m, friend, q, a));
	}

	public static String solution(int n, int m, int[][] friend, int q, int a) {
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int fr = find(friend[i][0]);

			if (fr == 0) {
				break;
			}

			union(fr, friend[i][1]);
		}

		return find(q) == a ? "YES" : "NO";
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[x] = y;
		}
	}

}
