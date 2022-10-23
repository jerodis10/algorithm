package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5604 {

    static int T;
    static int num[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            int ret = 0;
            num = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<2;i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            //¦��
            if((num[1] - num[0] -1) % 2 == 0 ) {
                ret = (num[1] + num[0]) * ((num[1] + num[0]) / 2);
            } else { //Ȧ��
                ret = (num[1] + num[0]) * (((num[1] + num[0]) / 2) - 1) + (num[1] + num[0]) / 2;
            }

            System.out.printf("#%d %d", t, ret);
            t++;
        }
    }
}
