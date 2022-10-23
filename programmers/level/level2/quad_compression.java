package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class quad_compression {
	
	static int[] answer;
	
	public int[] solution(int[][] arr) {
		answer = new int[2];
		int len = arr.length;
		dfs(0,0,len,arr);
		
		return answer;
    }
	
	public void dfs(int y, int x, int size, int[][] arr) {
		if(checkCompression(y,x,size,arr)) {
			answer[arr[y][x]]++;
			return;
		}
		
		dfs(y,x,size/2,arr);
		dfs(y+size/2,x,size/2,arr);
		dfs(y,x+size/2,size/2,arr);
		dfs(y+size/2,x+size/2,size/2,arr);
	}
	
	public boolean checkCompression(int y, int x, int size, int[][] arr) {
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(arr[y][x] != arr[i][j]) return false;
			}
		}
		return true;
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}}
		)).isEqualTo(
				new int[] {4,9}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][] {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},
					{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}}
		)).isEqualTo(
				new int[] {10,15}
		);
	}
}
