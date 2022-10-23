package Baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BJ_1436_bruteForce5 {

    static int N;
    static List<Integer> num;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int val = 666;
        int cnt = 0;
        while(true) {
            for(int i = val;i>=666;i/=10) {
                if(i % 1000 == 666) {
                    cnt++;
                    break;
                }
            }

            if(N == cnt) break;
            else val++;
        }

        System.out.printf("%d", val);

    }

}

