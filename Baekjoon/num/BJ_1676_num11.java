package Baekjoon.num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1676_num11 {
	
	static int T;
	static int N;
	static int num[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int num = Integer.parseInt(br.readLine());
		int two = 0;
		int five = 0;
 
		for (int i = 2; i <= num; i *= 2) {
	        two += num / i;
	    }
	    for (int i = 5; i <= num; i *= 5) {
	        five += num / i;
	    }


		System.out.println((two < five) ? two : five);
	
	}
		
}
