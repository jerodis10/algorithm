package ex;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class sol5 {

	int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	char[][] map;
	int[] start;
	int[] target;
	boolean[][] visited;
	int result;

	public int solution(String[] board) {
		result = Integer.MAX_VALUE;
		map = new char[board.length][board[0].length()];
		visited = new boolean[board.length][board[0].length()];
		start = search('R', board);
		target = search('G', board);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		for (int i = 0; i < 4; i++) {
			visited = new boolean[board.length][board[0].length()];
			dfs(start[0], start[1], i, 1);
		}

		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private boolean dfs(int curY, int curX, int curDir, int depth) {
		if (curY == target[0] && curX == target[1]) {
			result = Math.min(result, depth);
			return true;
		}

		visited[curY][curX] = true;

		int nextY = curY;
		int nextX = curX;
		while (true) {
			nextY += dir[curDir][0];
			nextX += dir[curDir][1];
			if(nextY < 0 || nextY >= map.length || nextX < 0 || nextX >= map[0].length) {
				nextY -= dir[curDir][0];
				nextX -= dir[curDir][1];
				break;
			}
			if(map[nextY][nextX] == 'D') {
				nextY -= dir[curDir][0];
				nextX -= dir[curDir][1];
				break;
			}
			visited[nextY][nextX] = true;
		}

		for (int i = 0; i < 4; i++) {
			int nextDirY = nextY + dir[i][0];
			int nextDirX = nextX + dir[i][1];
			if(nextDirY < 0 || nextDirY >= map.length || nextDirX < 0 || nextDirX >= map[0].length) continue;
			if(map[nextDirY][nextDirX] == 'D') continue;

			if (!visited[nextDirY][nextDirX]) {
				visited[nextDirY][nextDirX] = true;
				dfs(nextY, nextX, i, depth + 1);
			} else if(map[nextDirY][nextDirX] == 'G'){
				dfs(nextDirY, nextDirX, i, depth + 1);
			}
		}

		return false;
	}

	private int[] search(char ch, String[] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if (board[i].charAt(j) == ch) {
					return new int[]{i, j};
				}
			}
		}

		return new int[] {};
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}
		)).isEqualTo(
				7
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[]{".D.R", "....", ".G..", "...D"}
		)).isEqualTo(
				-1
		);
	}


}
