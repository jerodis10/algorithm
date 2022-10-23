package Baekjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470_TwoPointer2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 2_000_000_000;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = n - 1;
        int sum = 0;
        int ret = 0;
        int pick1 = 0;
        int pick2 = 0;
        
        while(left < right) {
        	sum = arr[left] + arr[right];
        	
        	if(Math.abs(sum) < max) {
        		pick1 = arr[left];
        		pick2 = arr[right];
        		max = Math.abs(sum);
        	}
        	
        	if(sum > 0) right--;
        	else left++;
        }
        
        System.out.println(pick1 + " " + pick2);
	}
		
}
