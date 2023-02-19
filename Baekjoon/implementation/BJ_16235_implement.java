package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16235_implement {

	static int n;
	static int m;
	static int k;
	static int[][] map;
	static int[][] tree;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
	static int ret;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		tree = new int[m][3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			tree[i][0] = Integer.parseInt(st.nextToken());
			tree[i][1] = Integer.parseInt(st.nextToken());
			tree[i][2] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, m, k, map, tree));
	}

	public static int solution(int a, int b, int c, int[][] arr, int[][] arr2){
		n = a;
		m = b;
		k = c;
		map = new int[n + 1][n + 1];
		int[][] original = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = 5;
				original[i][j] = arr[i - 1][j - 1];
			}
		}
		tree = arr2.clone();

		List<int[]> list = new ArrayList<>();
		for (int[] t : tree) {
			list.add(t);
		}

		while(k-- > 0) {
			Collections.sort(list, (o1, o2) -> o1[2] - o2[2]);

			// 봄
			Iterator<int[]> iter = list.iterator();
			int index = 0;
			while(iter.hasNext()) {
				int y = iter.next()[0];
				int x = iter.next()[1];
				int old = iter.next()[2];
				if (map[y][x] >= old) {
					map[y][x] -= old;
					list.set(index, new int[]{y, x, old + 1});
				} else {
					//여름
					map[y][x] += old / 2;
					iter.remove();
				}
				index++;
			}

//			for(int i = 0; i < list.size(); i++) {
//				int y = list.get(i)[0];
//				int x = list.get(i)[1];
//				int old = list.get(i)[2];
//				if (map[y][x] >= old) {
//					map[y][x] -= old;
//					list.set(i, new int[]{y, x, old + 1});
//				} else {
//					//여름
//					map[y][x] += old / 2;
//					list.remove(i);
//				}
//			}

			// 가을
			for(int i = 0; i < list.size(); i++) {
				int y = list.get(i)[0];
				int x = list.get(i)[1];
				int old = list.get(i)[2];
				if(old % 5 == 0) {
					for (int j = 0; j < 8; j++) {
						int ny = y + dir[j][0];
						int nx = x + dir[j][1];
						if (ny > n || ny < 1 || nx > n || nx < 1) continue;

						list.add(new int[]{ny, nx, 1});
					}
				}
			}

			// 겨울
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] += original[i][j];
				}
			}
		}

		return list.size();
	}



//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				1,1,1,
//				new int[][]{{1}},
//				new int[][]{{1,1,1}}
//		)).isEqualTo(1);
//	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				1,1,4,
//				new int[][]{{1}},
//				new int[][]{{1,1,1}}
//		)).isEqualTo(0);
//	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				5,2,1,
				new int[][]{{2, 3, 2, 3, 2},
							{2, 3, 2, 3, 2},
							{2, 3, 2, 3, 2},
							{2, 3, 2, 3, 2},
							{2, 3, 2, 3, 2}},
				new int[][]{{2, 1, 3},{3, 2, 3}}
		)).isEqualTo(2);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				5,2,2,
				new int[][]{{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2}},
				new int[][]{{2, 1, 3},{3, 2, 3}}
		)).isEqualTo(15);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				5,2,3,
				new int[][]{{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2}},
				new int[][]{{2, 1, 3},{3, 2, 3}}
		)).isEqualTo(13);
	}
	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				5,2,4,
				new int[][]{{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2}},
				new int[][]{{2, 1, 3},{3, 2, 3}}
		)).isEqualTo(13);
	}
	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				5,2,5,
				new int[][]{{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2}},
				new int[][]{{2, 1, 3},{3, 2, 3}}
		)).isEqualTo(13);
	}
	@Test
	public void testCase8() {
		Assertions.assertThat(solution(
				5,2,6,
				new int[][]{{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2},
						{2, 3, 2, 3, 2}},
				new int[][]{{2, 1, 3},{3, 2, 3}}
		)).isEqualTo(85);
	}


}

