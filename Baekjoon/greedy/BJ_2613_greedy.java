package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2613_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}

		solution(n, num);
	}

	public static void solution(int n, int[] num) {



	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				2
//				,7
//				,new int[]{2,3,2,3,1,2,7}
//		)).isEqualTo(
//				2
//		);
//	}

}
