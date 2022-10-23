package swea;

import java.util.Scanner;

public class swea_1865 {
    static double[][] a;
    static int n;
    static double max;
    static int[] visit; 

    public static void dfs(int x, int depth, double result) {
        result *= a[x][depth];
        visit[x] = 1;

        if(depth == n - 1) {
            if(max < result)
                max = result;
            visit[x] = 0;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visit[i] == 0 && result * a[i][depth+1] > max) dfs(i, depth+1, result);
        }
        visit[x] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            a = new double[n][n];
            visit = new int[n];
            max = 0.0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = sc.nextDouble() / 100;
                }
            }

            for(int i = 0; i < n; i++) {
                dfs(i, 0, 1);
            }
            System.out.printf("#%d %.6f\n", t, max*100);
        }
    }
}
