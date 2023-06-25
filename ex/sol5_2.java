package ex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sol5_2 {

	boolean[] visited;
	int[] origin;
	int count;
	List<String> list;
	int max;

	public int[] solution(int n, int[] info) {
		visited = new boolean[11];
		origin = info;
		count = n;
		list = new ArrayList<>();
		max = 0;

		dfs(-1, 0);

		if(list.isEmpty()) return new int[] {-1};
		else {
			Collections.sort(list);
			String[] s = list.get(0).split("");
			int[] result = new int[11];
			for (int i = 0; i < 11; i++) {
				result[i] = Integer.parseInt(s[i]);
			}
			return result;
		}
	}

	private void dfs(int cur, int sum) {
		if(sum == count) {
			int originSum = 0;
			int newSum = 0;
			for (int i = 0; i < 11; i++) {
				if (!visited[i] && origin[i] > 0) {
					originSum += (10 - i);
				} else if(visited[i]){
					newSum += (10 - i);
				}
			}
			if (originSum < newSum) {
				if(max <= newSum - originSum) {
					max = newSum - originSum;
					String s = "";
					for (int i = 0; i < 11; i++) {
						if (visited[i]) {
							s += String.valueOf(origin[i] + 1);
						} else {
							s += "0";
						}
					}
					list.add(s);
				}
			}

			return;
		}

		for (int i = cur + 1; i < 11; i++) {
			for (int j = 1; j <= 11; j++) {
				if (sum + j <= count) {
					visited[i] = true;
					dfs(i, sum + j);
					visited[i] = false;
				}
			}
		}
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5,
				new int[]{2,1,1,1,0,0,0,0,0,0,0}
		)).isEqualTo(
				new int[]{0,2,2,0,1,0,0,0,0,0,0}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				1,
				new int[]{1,0,0,0,0,0,0,0,0,0,0}
		)).isEqualTo(
				new int[]{-1}
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				9,
				new int[]{0,0,1,2,0,1,1,1,1,1,1}
		)).isEqualTo(
				new int[]{1,1,2,0,1,2,2,0,0,0,0}
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				10,
				new int[]{0,0,0,0,0,0,0,0,3,4,3}
		)).isEqualTo(
				new int[]{1,1,1,1,1,1,1,1,0,0,2}
		);
	}


}


