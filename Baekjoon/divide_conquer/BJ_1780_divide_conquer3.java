package Baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780_divide_conquer3 {
	
	static int N;
	static int map[][];
	static int num[];
	
	public static void division(int y, int x, int size) {
		if(size == 1) {
			if(map[y][x] == -1) {
				num[0]++;
				return;
			} else if(map[y][x] == 0){
				num[1]++;
				return;
			} else {
				num[2]++;
				return;
			}
		}
		
		boolean flag = true;
		int num2 = map[y][x];
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				if(map[i][j] != num2) flag = false;
			}
		}
		if(flag) {
			if(map[y][x] == -1) {
				num[0]++;
				return;
			} else if(map[y][x] == 0){
				num[1]++;
				return;
			} else {
				num[2]++;
				return;
			}
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				division(y+size/3*i, x+size/3*j, size/3);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        num = new int[3];
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        division(0,0,N);
        
        for(int i=0;i<3;i++) System.out.println(num[i]);
	
	}
}
