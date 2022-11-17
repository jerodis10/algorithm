package Baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_1956_shortest_path7 {

	static int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		long[][] dist = new long[V+1][V+1];

		for(int i=1;i<=V;i++) {
			Arrays.fill(dist[i], MAX);
		}

		int s,e,d;
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			dist[s][e] = Math.min(dist[s][e], d);
		}

		//플로이드 워셜
		// k = 경유지
		for(int i=1;i<=V;i++) {
			for(int j=1;j<=V;j++) {
				for(int k=1;k<=V;k++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}

		long result = MAX;
		for(int a=1;a<=V;a++) {
			result = Math.min(result, dist[a][a]);
		}

		if(result == MAX) System.out.print(-1);
		else System.out.print(result);
	}
		
}