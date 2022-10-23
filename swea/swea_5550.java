package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5550 {

    static int T;
    static int[] N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            int index = 0;
            String s = br.readLine();
            String c = "croak";
            boolean[] visited = new boolean[5];
            char[] cl = c.toCharArray();
            int[] check = new int[5];
            int minN= 987654321;

            for(int i=0;i<5;i++) {
                visited[i] = false;
            }

            for(int i=0;i<s.length();i++) {
                if(!visited[i] && s.charAt(index) == cl[index]) {
                    visited[i] = true;
                    ++index;

                }


            }

            for(int i=0;i<5;i++) {
                if(minN > check[i]) minN = check[i];
            }

            System.out.printf("#%d %d", t, minN);
            t++;
        }

    }

}
