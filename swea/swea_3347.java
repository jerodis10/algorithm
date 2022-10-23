package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3347 {

    static int T;
    static int N, M;
    static int A[];
    static int B[];
    static int Count[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            Count = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(A[j] <= B[i]) {
                        Count[j]++;
                        break;
                    }
                }
            }

//            for(int i=0;i<N;i++) System.out.println(Count[i]);

            int ret = 0;
            int temp = 0;
            for(int i=0;i<N;i++) {
                if(temp < Count[i]) {
                    temp = Count[i];
                    ret = i;
                }
            }
            System.out.printf("#%d %d", t, ret + 1);
        }

    }

}
