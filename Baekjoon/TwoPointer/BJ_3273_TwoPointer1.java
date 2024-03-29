package Baekjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_3273_TwoPointer1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int x = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        
        int start = 0;
        int end = n - 1;
        int sum = 0;
        int ret = 0;
        
        while(start < end) {
        	sum = arr[start] + arr[end];
        	if(sum == x) ret++;
        	
        	if(sum <= x) start++;
        	else end--;
        }
        
        System.out.println(ret);
	}
		
}
