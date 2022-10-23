package programmers.level.level2;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class length_of_visit {
	
	public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited = new boolean[11][11][11][11];
        Map<String, int[]> map = new HashMap<>();
        
        map.put("U", new int[] {-1,0});
        map.put("D", new int[] {1,0});
        map.put("R", new int[] {0,1});
        map.put("L", new int[] {0,-1});
        String[] dirList = dirs.split("");
        
        int curY = 5;
        int curX = 5;
        int preY = 5;
        int preX = 5;
        visited[curY][curX][preY][preX] = true;
        for(String dir : dirList) {
    		int nextY = curY +  map.get(dir)[0];
    		int nextX = curX + map.get(dir)[1];
    		if(nextY < 0 || nextY >= 11 || nextX < 0 || nextX >= 11) continue;
    		if(!visited[nextY][nextX][curY][curX]) answer++;
    		visited[nextY][nextX][curY][curX] = true;
    		visited[curY][curX][nextY][nextX] = true;
    		preY = curY;
    		preX = curX;
    		curY = nextY;
    		curX = nextX;
        }
        
        return answer;
   }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"ULURRDLLU"
		)).isEqualTo(
				7
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"LULLLLLLU"
		)).isEqualTo(
				7
		);
	}
}
