import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class ex {

	public static int solution(int n, int[][] meetings) {
		int answer = 0;

		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int count = 0;
		int time = 1;
		int index = 0;
		int roomIndex = 0;
		int[] rooms = new int[n];
		int[] result = new int[n];
		while (count < meetings.length) {
			for (int i = 0; i < n; i++) {
				if (rooms[i] > 0) {
					rooms[i]--;
				}
			}
			if (time <= meetings[index][0]) {
				if(rooms[roomIndex] > 0){
					if (roomIndex == n - 1) {
						roomIndex = 0;
					} else {
						roomIndex++;
					}
					time++;
					continue;
				}
				rooms[roomIndex] = time + meetings[index][1];
				result[roomIndex]++;
				if (roomIndex == n - 1) {
					roomIndex = 0;
				} else {
					roomIndex++;
				}
				index++;
				count++;
				time++;
			} else {
				time++;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (max < result[i]) {
				max = result[i];
				if (answer > i) {
					answer = i;
				}
			}
		}

		return answer;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2, new int[][] {{0,10},{1,5},{2,7},{3,4}}
		)).isEqualTo(0);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3, new int[][] {{1,20},{2,10},{3,5},{4,9},{6,8}}
		)).isEqualTo(1);
	}

//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				4,4,6
//		)).isEqualTo(7);
//	}


}
