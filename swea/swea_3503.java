package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_3503 {

    static int T;
    static int N;
//	static int num[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            N = Integer.parseInt(br.readLine());
//            num = new int[N];
            LinkedList<Integer> list = new LinkedList<Integer>();
            List<Integer> num = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                num.add(Integer.parseInt(st.nextToken()));
//            	num[i] = Integer.parseInt(st.nextToken());
            }

//            Collections.sort(num);
//            Arrays.sort(num, Collections.reverseOrder());

            Collections.sort(num, Collections.reverseOrder());
            list.add(num.get(0));

            for(int i=1;i<num.size();i++) {
                if(i % 2 == 1) {
                    list.addFirst(num.get(i));
                } else {
                    list.addLast(num.get(i));
                }
            }

            int minN = 987654321;


            System.out.printf("#%d", t);
            t++;
        }

    }

}
