package Baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629_divide_conquer4 {
	
	static long A;
	static long B;
	static long C;
	
	public static long dfs(long num, long exponent) {
		if(exponent == 1) return num % C;
		
		long temp = dfs(num, exponent/2);
		if(exponent % 2 == 1) return (temp * temp % C) * num % C;
		
		return temp * temp % C;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A =	Long.valueOf(st.nextToken());
		B =	Long.valueOf(st.nextToken());
		C =	Long.valueOf(st.nextToken());
		
        System.out.printf("%d", dfs(A, B));
	
	}
}
