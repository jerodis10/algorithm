package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol25 {

	char[][] map;
	int ret = 0;
	boolean[][][] visited;

	int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	int col, row;

	public int solution(String[] R) {
		col = R.length;
		row = R[0].length();
		map = new char[col][row];
		visited = new boolean[col][row][4];

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				map[i][j] = R[i].charAt(j);
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
			if(nextY < 0 || nextX < 0 || nextY >= col || nextX >= row) {
				nextY -= dir[direction][0];
				nextX -= dir[direction][1];
				break;
			}
			if(map[nextY][nextX] == 'X') {
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
				new String[]{"...X..","....XX","..X..."}
		)).isEqualTo(
				6
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[]{"....X..","X......",".....X.","......."}
		)).isEqualTo(
				15
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new String[]{"...X.",".X..X","X...X","..X.."}
		)).isEqualTo(
				9
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new String[]{".....",
						     "XXXXX",
						     ".....",
						     "....."}
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				new String[]{"...X.",
							 "X....",
							 ".....",
							 "..X.."}
		)).isEqualTo(
				13
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				new String[]{".x...",
							 "x....",
							 ".....",
							 "..x.."}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				new String[]{".....",
							 ".....",
							 ".....",
							 "....."}
		)).isEqualTo(
				14
		);
	}

	@Test
	public void testCase8() {
		Assertions.assertThat(solution(
				new String[]{"...X..", "....XX", "..X..."}
		)).isEqualTo(
				14
		);
	}

}
