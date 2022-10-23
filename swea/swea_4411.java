package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4411 {

    static int T;
    static int N;
    static int num[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }



            System.out.printf("#%d", t);
            t++;
        }

    }

}
