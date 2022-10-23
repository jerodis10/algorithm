package programmers.kit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class farthest_node {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] dist;
	static int max = Integer.MIN_VALUE;
	
	public static int solution(int n, int[][] edge) {
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		dist = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<edge.length; i++) {
			int y = edge[i][0];
			int x = edge[i][1];
			
			graph[y].add(x);
			graph[x].add(y);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		dist[1] = 0;
		
		while(!q.isEmpty()) {
			int k = q.poll();
			
			for(Integer i : graph[k]) {
				if(!visited[i]) {
					q.offer(i);
					visited[i] = true;
					dist[i] = dist[k] + 1;
					max = Math.max(max, dist[i]);
				}
			} 
		}
		
		int cnt = 0;
	    for (int i : dist) {
	        if (i == max)
	            cnt++;
	    }

	    return cnt;
	}
	
	@Test
	public void testCase() {
		Assert.assertEquals(3, solution(6, new int[][] {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}}));
	}
}
