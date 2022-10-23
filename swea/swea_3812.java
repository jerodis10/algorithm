package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3812 {

    static int T;
    static int num[];
    static int visited[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            num = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<num.length;i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            visited = new int[num[6]];

            for(int i=0;i<num[0];i++) {
                for(int j=0;j<num[1];j++) {
                    for(int k=0;k<num[2];k++) {
                        int color = Math.abs(i - num[3]) + Math.abs(j - num[4]) + Math.abs(k - num[5]);
                        color %= num[6];
                        visited[color] += 1;
                    }
                }
            }

            System.out.printf("#%d", t);

            for(int i=0;i<num[6];i++) {
                System.out.printf(" %d", visited[i]);
            }
            t++;
        }
    }
}
