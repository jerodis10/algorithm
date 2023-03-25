package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1931_greedy2 {
	
	static int N;
	static int num[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        num = new int[N][2];
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	num[i][0] = Integer.parseInt(st.nextToken());
        	num[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(num, (o1, o2) -> {
        	if(o1[1] == o2[1]) {
        		return Integer.compare(o1[0], o2[0]);
        	} else {
        		return Integer.compare(o1[1], o2[1]);
        	}
        });
        
        int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= num[i][0]) {
				prev_end_time = num[i][1];
				count++;
			}
		}
        
        System.out.printf("%d", count);
	
	}
	
}
