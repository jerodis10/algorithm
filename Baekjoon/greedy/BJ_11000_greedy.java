package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11000_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Integer[][] rooms = new Integer[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			rooms[i][0] = Integer.parseInt(st.nextToken());
			rooms[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, rooms));
	}

	public static int solution(int n, Integer[][] rooms) {
		Arrays.sort(rooms, ((o1, o2) -> {
			if(o1[0] == o2[0]) return o1[1] - o2[1];
			return o1[0] - o2[0];
		}));
		PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			} else {
				return o1[1] - o2[1];
			}
		});

		pq.add(rooms[0]);
		for (int i = 1; i < n; i++) {
			if (pq.peek()[1] > rooms[i][0]) {
				pq.add(rooms[i]);
			} else {
				pq.poll();
				pq.add(rooms[i]);
			}
		}

		return pq.size();
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				3
//				, new int[][]{{1,3},{2,4},{3,5}}
//		)).isEqualTo(
//				2
//		);
//	}

}
