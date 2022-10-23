package Baekjoon.etc;
import java.io.*;
import java.util.StringTokenizer;
public class BJ_1010 {
    public static final int MAX = 30;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int combination[][] = new int[MAX][MAX];
        for(int n=0;n<MAX;n++) {
            for(int m=0;m<MAX;m++) {
                if(n==m || n==0 || m==0) combination[n][m] = 1;
                else { combination[n][m] = combination[n-1][m-1] + combination[n][m-1]; }
            }
        }
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<testCase;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());
            sb.append(combination[west][east]).append("\n");
        }
        System.out.println(sb.toString());
    }
}