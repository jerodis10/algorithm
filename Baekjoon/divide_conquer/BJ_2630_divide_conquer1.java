package Baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_divide_conquer1 {
	
	static int N;
	static int map[][];
	static int blue;
	static int white;
	
	public static void division(int y, int x, int size) {
		if(size == 1) {
			if(map[y][x] == 0) {
				white++;
				return;
			} else {
				blue++;
				return;
			}
		}
		
		boolean flag = true;
		int num = map[y][x];
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				if(map[i][j] != num) flag = false;
			}
		}
		if(flag) {
			if(map[y][x] == 0) {
				white++;
				return;
			} else {
				blue++;
				return;
			}
		}
		
		division(y, x, size/2);
		division(y, x+size/2, size/2);
		division(y+size/2, x, size/2);
		division(y+size/2, x+size/2, size/2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        blue = 0;
        white = 0;
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
	        	map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        division(0,0,N);
        
        System.out.printf("%d", white);
        System.out.println("");
        System.out.printf("%d", blue);
	
	}
}
