package Baekjoon.binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1450_binarySearch_etc { 

	static int n,c;
	static int[] arr;
	static ArrayList<Integer> left;
	static ArrayList<Integer> right;
	static int index;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		left = new ArrayList<Integer>();
		right = new ArrayList<Integer>();
		dfs(0,n/2,0,left);
		dfs(n/2+1,n-1,0,right);
		
		Collections.sort(left);
		Collections.sort(right);
		int ans = 0;
		for(int i=0;i<left.size();i++){
            index = -1;
            binarySearch(0, right.size()-1, left.get(i));
            ans += index + 1;
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
    
    public static void binarySearch(int start, int end, int val){
        if(start > end) return;
        
        int mid = (start+end) / 2;
            
        if(right.get(mid)+val <= c){
            index = mid;
            binarySearch(mid+1, end, val);
        } else {
            binarySearch(start, mid-1, val);
        }
    }
}
