package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea_3263 {

    static int T;
    static int N;
    static List<Integer> num;
    static List<Integer> num2;
    static List<Integer> num3;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            int ret = 0;
            N = Integer.parseInt(br.readLine());
            num = new ArrayList<Integer>();
            num2 = new ArrayList<Integer>();
//            num3 = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                int a = Integer.parseInt(st.nextToken());
                num.add(a);
//            	num2.add(a);
            }

            Collections.sort(num2);

            int startIndex = 0;
            int endIndex = 0;
            boolean flag = false;
            int cnt = 0;
            int max_len = 0;
            for(int i=0;i<num.size()-1;i++) {
                if(num.get(i+1) - num.get(i) == 1) {
                    flag = true;
                    startIndex = i;
                    if(cnt == 0) cnt = 2;
                    else cnt++;
                }
                if(flag && num.get(i+1) - num.get(i) != 1) {
                    if(max_len < cnt) max_len = cnt;
                    cnt = 0;
                }
            }

            endIndex = startIndex + cnt - 1;

            for(int i=0;i<num.size();i++) {
                if(i == startIndex || i == endIndex) continue;
                if(num.get(i) < num.get(startIndex)) {
                    num2.add(0, num.get(i));
                    ret++;
                }
                else {
                    num2.add(num.get(i));
                    ret++;
                }
            }

            System.out.printf("#%d %d", t, ret);
            t++;
        }

    }
}
