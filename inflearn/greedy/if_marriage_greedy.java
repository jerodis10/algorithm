package inflearn.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class if_marriage_greedy {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] person = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, person));
	}

	public static int solution(int n, int[][] person) {
		Queue<int[]> q = new LinkedList<>();
		Arrays.sort(person, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		for (int i = 0; i < n; i++) {
			person[i][1]--;
		}
		q.add(person[0]);
		int index = 1;
		int max = 0;
		while (!q.isEmpty() && index < n) {
			int[] cur = q.peek();
			if (cur[1] >= person[index][0]) {
				q.add(person[index]);
				index++;
			} else {
				q.poll();
				q.add(person[index]);
				index++;
			}

			max = Math.max(max, q.size());
			if(index == n) break;
			int[] temp = person[index];
			while (!q.isEmpty()) {
				if (temp[0] > q.peek()[1]) {
					q.poll();
				} else {
					break;
				}
			}
		}

		return max;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5
				,new int[][]{{14,18},{12,15},{15,20},{20,30},{5,14}}
		)).isEqualTo(
				2
		);
	}

}
