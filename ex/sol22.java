package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class sol22 {

	static ArrayList<Integer>[] G1, G2;
	static int[][] dp;
	public int solution(int n1, int[][] g1, int n2, int[][] g2) {

		G1 = new ArrayList[n1+1];
		G2 = new ArrayList[n2+1];
		for(int i=0; i<=n1; i++) G1[i]=new ArrayList<>();
		for(int i=0; i<=n2; i++) G2[i]=new ArrayList<>();

		for(int[] next : g1) {
			G1[next[0]].add(next[1]);
			G1[next[1]].add(next[0]);
		}
		for(int[] next : g2) {
			G2[next[0]].add(next[1]);
			G2[next[1]].add(next[0]);
		}

		dp = new int[101][101];
		for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);


		return makeAnswer(1,0,1,0);
	}

	static int makeAnswer(int child1, int parent1, int child2, int parent2) {

		if(dp[child1][child2]!=-1) return dp[child1][child2];

		int n1 = G1[child1].size();
		int n2 = G2[child2].size();
		int source = n1+n2;
		int sink = source+1;

		MCMF mcmf = new MCMF(n1+n2+2, source, sink);

		for(int i=0; i<G1[child1].size(); i++) {
			int from = G1[child1].get(i);
			if(from==parent1) continue;

			for(int j=0; j<G2[child2].size(); j++) {
				int to = G2[child2].get(j);
				if(to==parent2) continue;

				int cost = makeAnswer(from, child1, to, child2);
				mcmf.addEdge(i, n1+j, 1, -cost);
			}
			mcmf.addEdge(source, i, 1, 0);
		}
		for(int i=0; i<n2; i++) {
			mcmf.addEdge(n1+i, sink, 1, 0);
		}
		return dp[child1][child2] = -mcmf.getMCMF()[1]+1;
	}

	static class MCMF {
		int size, source, sink;
		int[] dist, pre, edgeIdx;
		ArrayList<int[]>[] graph;

		MCMF(int size, int source, int sink){
			graph = new ArrayList[size];
			for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();
			pre = new int[size];
			edgeIdx = new int[size];
			this.size=size;
			this.source=source;
			this.sink=sink;
		}

		void addEdge(int from, int to, int cap, int cost) {
			graph[from].add(new int[] {to, cap, cost, graph[to].size()});
			graph[to].add(new int[] {from, 0, -cost, graph[from].size()-1});
		}

		public int[] getMCMF(){

			int maxFlow=0, minCost=0;
			while(true) {
				dist = new int[size];
				Arrays.fill(dist, Integer.MAX_VALUE);
				boolean[] inQ = new boolean[size];
				Queue<Integer> q = new LinkedList<>();
				q.add(source);
				inQ[source]=true;
				dist[source]=0;

				while(!q.isEmpty()) {
					int now = q.poll();
					inQ[now] = false;
					for(int i=0; i<graph[now].size(); i++) {
						int[] next = graph[now].get(i);
						if(next[1]>0&&dist[next[0]]>dist[now]+next[2]) {
							dist[next[0]]=dist[now]+next[2];
							pre[next[0]]=now;
							edgeIdx[next[0]]=i;
							if(!inQ[next[0]]) {
								q.add(next[0]);
								inQ[next[0]]=true;
							}
						}
					}
				}

				if(dist[sink]==Integer.MAX_VALUE) break;

				int minFlow = Integer.MAX_VALUE;
				int costSum=0;
				for(int i=sink; i!=source; i=pre[i]) {
					int[] next = graph[pre[i]].get(edgeIdx[i]);
					minFlow = Math.min(minFlow, next[1]);
					costSum+=next[2];
				}
				for(int i=sink; i!=source; i=pre[i]) {
					int[] next = graph[pre[i]].get(edgeIdx[i]);
					next[1]-=minFlow;
					graph[next[0]].get(next[3])[1]+=minFlow;
				}
				maxFlow+=minFlow;
				minCost+=costSum*minFlow;
			}

			return new int[] {maxFlow, minCost};
		}
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				8,
				new int[][]{{3,1},{5,7},{8,7},{2,3},{3,6},{1,5},{4,3}},
				9,
				new int[][]{{1,5},{5,6},{3,7},{3,1},{7,4},{7,2},{9,8},{5,9}}
		)).isEqualTo(
				7
		);
	}


}
