package Baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018_bruteForce4 {

    static int N;
    static int M;
    static int minN;
    static String map[];
    static boolean arr[][];

    public static void solve(int y, int x) {
        int count = 0;
        boolean flag = arr[y][x];
        for(int i=y;i<y+8;i++) {
            for(int j=x;j<x+8;j++) {
                if(arr[i][j] != flag) count++;
                flag = (!flag);
            }
            flag = !flag;
        }
        count = Math.min(count, 64 - count);
        if(minN > count) minN = count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N];
        minN = 64;
        arr = new boolean[N][M];
        for(int i=0;i<N;i++) {
            map[i] = br.readLine();
            for(int j=0;j<M;j++) {
                if(map[i].charAt(j) == 'W') arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        for(int i=0;i<N-7;i++) {
            for(int j=0;j<M-7;j++) {
                solve(i,j);
            }
        }

        System.out.printf("%d", minN);

    }

}

