package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1339_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strArr = new String[n];
		for (int i = 0; i < n; i++) {
			strArr[i] = br.readLine();
		}

		System.out.println(solution(n, strArr));
	}

	public static int solution(int n, String[] strArr) {
		int[] alpha = new int[26];

		for (int i = 0; i < n; i++) {
			int temp = (int) Math.pow(10, strArr[i].length() - 1);
			for (int j = 0; j < strArr[i].length(); j++) {
				alpha[(int) strArr[i].charAt(j) - 65] += temp;
				temp /= 10;
			}
		}

		Arrays.sort(alpha);
		int index = 9;
		int sum = 0;
		for (int i = alpha.length - 1; i >= 0; i--) {
			if (alpha[i] == 0) {
				break;
			}

			sum += alpha[i] * index;
			index--;
		}

		return sum;
	}
	
}
