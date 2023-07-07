package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol14 {

	int[][] userList;
	int[] emoticonList;

	int[] discounts = {10, 20, 30, 40};

	int[] answer;

	int[] arr;


	public int[] solution(int[][] users, int[] emoticons) {
		userList = users;
		emoticonList = emoticons;
		answer = new int[2];
		arr = new int[emoticons.length];

		for (int i = 0; i < emoticons.length; i++) {
			for (int j = 0; j < 4; j++) {
				dfs(i, j, 0, 0);
			}
		}

		return answer;
	}

	private void dfs(int index, int d_index, int cost, int plusCount) {
		arr[index] = d_index;

		int c_sum = 0;
		int p_sum = 0;
		for (int i = 0; i < userList.length; i++) {
			int sum = 0;
			for (int j = 0; j < emoticonList.length; j++) {
				if (userList[i][0] <= discounts[arr[j]]) {
					c_sum += emoticonList[j] * ((float)(100 - discounts[arr[j]]) / 100);
					sum += emoticonList[j] * ((float)(100 - discounts[arr[j]]) / 100);
				}
			}
			if(userList[i][1] <= sum) {
				c_sum -= sum;
				p_sum++;
			}
		}

		if (answer[0] < p_sum) {
			answer[0] = p_sum;
			answer[1] = c_sum;
		} else if (answer[0] == p_sum) {
			answer[1] = Math.max(answer[1], c_sum);
		}

		for (int i = index + 1; i < emoticonList.length; i++) {
			for (int j = 0; j < 4; j++) {
				dfs(i, j, 0, 0);
			}
		}
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][]{{40,10000},{25,10000}},
				new int[]{7000,9000}
		)).isEqualTo(
				new int[]{1,5400}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][]{{40, 2900},{23, 10000},{11,5200},{5,5900},{40,3100},{27,9200},{32,6900}},
				new int[]{1300, 1500, 1600, 4900}
		)).isEqualTo(
				new int[]{4,13860}
		);
	}


}
