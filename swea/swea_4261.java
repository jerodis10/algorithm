package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4261 {

    static int T;
    static String N;
    static int M;
    static String str[];
    static String[] key = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            int ret = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = st.nextToken();
            M = Integer.parseInt(st.nextToken());
            str = new String[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                str[i] = st.nextToken();
            }

            for(int i=0;i<M;i++) {
                if(str[i].length() == N.length()) {
                    int cnt = 0;
                    for(int j=0; j<N.length();j++) {
                        int index = Integer.parseInt(N.substring(j, j+1)) - 2;
                        if(!key[index].contains(str[i].substring(j, j+1))) break;
                        cnt++;
                    }
                    if(cnt == N.length()) ret++;
                }
            }

            System.out.printf("#%d %d", t, ret);
            t++;
        }

    }

}
