package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class swea_5521 {

    static int T;
    static int N;
    static int M;
    static int stu[];
    static int friend[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            int cnt = 0;
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> list3 = new ArrayList<Integer>();
            Set<Integer> list2 = new HashSet<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            friend = new int[M][2];
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                friend[i][0] = Integer.parseInt(st.nextToken());
                friend[i][1] = Integer.parseInt(st.nextToken());
            }
//            for(int i=0;i<N;i++) {
//            	stu[i] = i + 1;
//            }

            for(int i=0;i<M;i++) {
                if(friend[i][0] == 1) {
                    list.add(friend[i][1]);
//            		list2.add(friend[i][1]);
                }
                if(friend[i][1] == 1) {
                    list.add(friend[i][0]);
//            		list2.add(friend[i][0]);
                }
            }

            for(int i=0;i<M;i++) {
                if(list.contains(friend[i][0])) {
                    list3.add(friend[i][1]);
                }
                if(list.contains(friend[i][1])) {
                    list3.add(friend[i][0]);
                }
            }

            for(int i=0;i<list.size();i++) {
                list2.add(list.get(i));
            }
            for(int i=0;i<list3.size();i++) {
                list2.add(list3.get(i));
            }

            if(list2.contains(1)) list2.remove(1);

            System.out.printf("#%d %d", t, list2.size());
            t++;
        }

    }

}
