package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Friends_4_Block {
	
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map = new char[m][n];
		
		for(int i=0;i<m;i++) {
			map[i] = board[i].toCharArray();
		}
		
		while(true) {
			int cnt = checkBlock(m, n, map);
			if(cnt == 0) break;
			answer += cnt;
			
			dropBlock(m, n, map);
		}
		
		return answer;
    }
	
	public int checkBlock(int m, int n, char[][] map) {
		int cnt = 0;
		boolean[][] isChecked = new boolean[m][n];
		
		for(int i=0;i<m-1;i++) {
			for(int j=0;j<n-1;j++) {
				if(map[i][j] == '.') continue;
				checkFour(map, isChecked, i, j);
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(isChecked[i][j]) {
					cnt++;
					map[i][j] = '.';
				}
			}
		}
		
		return cnt;
	}
	
	public void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
		char block = map[i][j];
		
		for(int y=i;y<i+2;y++) {
			for(int x=j;x<j+2;x++) {
				if(map[y][x] != block) return;
			}
		}
		
		for(int y=i;y<i+2;y++) {
			for(int x=j;x<j+2;x++) {
				isChecked[y][x] = true;
			}
		}
	}
	
	public void dropBlock(int m, int n, char[][] map) {
		for(int x=0;x<n;x++) {
			for(int y=m-1;y>=0;y--) {
				if(map[y][x] == '.') {
					for(int ny=y-1;ny>=0;ny--) {
						if(map[ny][x] != '.') {
							map[y][x] = map[ny][x];
							map[ny][x] = '.';
							break;
						}
					}
				}
			}
		}
	}
	
	
//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				5,
//				new int[] {2,1,1,1,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {0,2,2,0,1,0,0,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				1,
//				new int[] {1,0,0,0,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {-1}
//		);
//	}
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				9,
//				new int[] {0,0,1,2,0,1,1,1,1,1,1}
//		)).isEqualTo(
//				new int[] {1,1,2,0,1,2,2,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				10,
//				new int[] {0,0,0,0,0,0,0,0,3,4,3}
//		)).isEqualTo(
//				new int[] {1,1,1,1,1,1,1,1,0,0,2}
//		);
//	}
}
