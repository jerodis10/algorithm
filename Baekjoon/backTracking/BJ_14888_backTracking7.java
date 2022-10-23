package Baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_backTracking7 {

	static int N;
	static int num[];
	static int cal[];
	static int minN;
	static int maxN;
	
	public static void dfs(int sum, int count) {
		if(count == N-1) {
			if(minN > sum) minN = sum;
			if(maxN < sum) maxN = sum;
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(cal[i] > 0) {
				int n;
				if(i == 0) {
					n = sum + num[count+1];
				} else if(i == 1) {
					n = sum - num[count+1];
				} else if(i == 2) {
					n = sum * num[count+1];
				} else {
					n = sum / num[count+1];
				}
				cal[i]--;
				dfs(n,count+1);
				cal[i]++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        cal = new int[4];
        minN = 987654321;
        maxN = -987654321;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
        	cal[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(num[0],0);
        
        
        System.out.printf("%d %d", maxN, minN);
	
	}
}
