package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4613 {

    static int T;
    static int N;
    static int M;
    static int minN;
    static String map[];
    static int cnt[][];
    static int check[];

    public static void dfs(int n, int min, int st) {
        if(n >= N) {
            for(int i=0;i<3;i++) {
                if(check[i] <= 0) return;
            }
            if(minN > min) minN = min;
            return;
        }

        if(n == 0) {
            min += (cnt[n][1]+cnt[n][2]);
            check[0] += 1;
            dfs(n+1, min, 0);
        } else if(n == N-1) {
            min += (cnt[n][0]+cnt[n][1]);
            check[2] += 1;
            dfs(n+1, min, 2);
        } else {
            for(int i=st;i<=st+1;i++) {
                for(int j=0; j<3;j++) {
                    if(j != i) {
                        min += (cnt[n][j]);
                        check[i] += 1;
                    }
                }
                dfs(n+1, min, i);
                for(int j=0; j<3;j++) {
                    if(j != i) {
                        min -= (cnt[n][j]);
                        check[i] -= 1;
                    }
                }
            }
        }
        return;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            minN = 987654321;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new String[N];
            cnt = new int[N][3];
            check = new int[N];

            for(int i=0;i<N;i++) {
                map[i] = br.readLine();
            }

            for(int i=0;i<N;i++) check[i]=0;

            for(int i=0;i<N;i++)
                for(int j=0;j<M;j++) {
                    if(map[i].charAt(j) == 'W') cnt[i][0]++;
                    if(map[i].charAt(j) == 'B') cnt[i][1]++;
                    if(map[i].charAt(j) == 'R') cnt[i][2]++;
                }
            dfs(0, 0, 0);

            System.out.printf("#%d %d", t, minN);
            System.out.println(" ");
            t++;
        }
    }
}
