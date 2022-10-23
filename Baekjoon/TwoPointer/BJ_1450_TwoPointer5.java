package Baekjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1450_TwoPointer5 {
	
	static int n,c;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		dfs(0,n/2,0,left);
		dfs(n/2+1,n-1,0,right);
		
		Collections.sort(left);
		Collections.sort(right);
		int ans = 0;
		int e = right.size()-1;
		for(int i=0;i<left.size();i++){
			while(e>= 0 && left.get(i)+right.get(e) > c){
				e--;				
			}
			ans += e+1;
		}
		System.out.println(ans);
	}
	
	public static void dfs(int cur, int end,int sum, ArrayList<Integer> list){
		if(sum > c) return;
		if(cur > end) {
			list.add(sum);
			return;
		}
		dfs(cur+1,end,sum,list);
		dfs(cur+1,end,sum+arr[cur],list);
	}
		
}
