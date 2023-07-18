package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol25 {

	char[][] map;
	int ret = 0;
	boolean[][][] visited;

	int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	int c, r;

	public int solution(int n, int k, String[] rooms) {
		c = n;
		r = k;
		map = new char[n][k];
		visited = new boolean[n][k][4];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				map[i][j] = rooms[i].charAt(j);
			}
		}

		ret++;

		dfs(0, 0, 0);

		return ret;
	}

	private void dfs(int y, int x, int direction) {
		if(visited[y][x][direction]) return;
		visited[y][x][direction] = true;

		int nextY = y;
		int nextX = x;
		while (true) {
			nextY += dir[direction][0];
			nextX += dir[direction][1];
			if(nextY < 0 || nextX < 0 || nextY >= c || nextX >= r) {
				nextY -= dir[direction][0];
				nextX -= dir[direction][1];
				break;
			}
			if(map[nextY][nextX] == 'x') {
				nextY -= dir[direction][0];
				nextX -= dir[direction][1];
				break;
			}

			if(visited[nextY][nextX][direction]) return;
			visited[nextY][nextX][direction] = true;

			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				if(i == direction) continue;
				if(visited[nextY][nextX][i]) flag = false;
			}

			if(flag) ret++;
		}

		int nextDir = 0;
		if(direction == 3) nextDir = 0;
		else nextDir = direction + 1;

		dfs(nextY, nextX, nextDir);
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3,6,
				new String[]{"...x..","....xx","..x..."}
		)).isEqualTo(
				6
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,7,
				new String[]{"....x..","x......",".....x.","......."}
		)).isEqualTo(
				15
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				4,5,
				new String[]{"...x.",".x..x","x...x","..x.."}
		)).isEqualTo(
				9
		);
	}


}
