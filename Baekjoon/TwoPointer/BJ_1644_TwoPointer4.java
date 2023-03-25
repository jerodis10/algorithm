package Baekjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1644_TwoPointer4 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[n+1];
        ArrayList<Integer> prime_num = new ArrayList<>();
        prime[0] = prime[1] = true;
        
        // 1. 소수 구하기
        for(int i=2;i*i<=n;i++) 
        	if(!prime[i])
        		for(int j=i*i;j<=n;j+=i)
        			prime[j] = true;
        
        for(int i=1;i<=n;i++)
        	if(!prime[i]) prime_num.add(i);
        
        
        // 2. 연속합으로 주어진 정수 구할 수 있는지 판별
        int left = 0, right = 0, sum = 0, ret = 0;
        while(true) {
        	if(sum >= n) sum -= prime_num.get(left++);
        	else if(right == prime_num.size()) break;
        	else sum += prime_num.get(right++);
        	if(n == sum) ret++;
        }
        
        System.out.println(ret);
	}
		
}
