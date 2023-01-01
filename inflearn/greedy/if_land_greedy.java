package inflearn.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class if_land_greedy {

	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[][] costs = new int[e][2];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i][0] = Integer.parseInt(st.nextToken());
			costs[i][1] = Integer.parseInt(st.nextToken());
			costs[i][2] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(v, e, costs));
	}

	public static int solution(int v, int e, int[][] costs) {
		Arrays.sort(costs, (int[] o1, int[] o2) -> o1[2] - o2[2]);
		parent = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		int total = 0;
		for(int[] edge: costs) {
			int from = edge[0];
			int to = edge[1];
			int cost = edge[2];

			int fromParent = findParent(from);
			int toParent = findParent(to);

			if (fromParent != toParent) {
				total += cost;
				union(from, to);
			}
		}

		return total;
	}

	public static int findParent(int node) {
		if(parent[node] == node) return node;
		return parent[node] = findParent(parent[node]);
	}

	public static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x != y) {
			parent[x] = y;
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				9
				,12
				,new int[][]{{1,2,12},{1,9,25},{2,3,10},{2,8,17},{2,9,8},{3,4,18},
						{3,7,55},{4,5,44},{5,6,60},{5,7,38},{7,8,35},{8,9,15}}
		)).isEqualTo(
				196
		);
	}

}
