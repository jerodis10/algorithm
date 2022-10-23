package Baekjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806_TwoPointer3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int ret = 100_000;
        int sum = 0;
        int left = 0;
        int right = 0;
        
        while(true) {
        	if(sum >= s) {
        		sum -= arr[left++];
        		ret = Math.min(ret, right - left + 1);
        	}
        	else if(right == n) break;
        	else sum += arr[right++];
        }
        
        if(ret == 100_000) System.out.println(0);
        else System.out.println(ret);
	}
		
}
