package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_greedy4 {
	
	static int N;
	static int num[];
	static int minN;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정 
		StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");
 
		while (subtraction.hasMoreTokens()) {
			int temp = 0;
 
			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
			
			// 덧셈으로 나뉜 토큰들을 모두 더한다. 
			while (addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			// 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		
		System.out.println(sum);
	}
}
