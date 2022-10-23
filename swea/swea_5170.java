package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_5170 {

    static int T;
    static int N;
    //	static int num[][];
//	static int visited[][];
    public class Point {
        private int y;
        private int x;

        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            N = Integer.parseInt(br.readLine());
//            num = new int[N][2];
            List<Point> num = new ArrayList<Point>();
            Point adj[][];
            adj = new Point[2001][2001];
//            List<List<Point>> adj = new ArrayList<List<Point>>();
//            visited = new int[2001][2001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
//            	num[i][0] = Integer.parseInt(st.nextToken());
//            	num[i][1] = Integer.parseInt(st.nextToken());
                num.get(i).setY(Integer.parseInt(st.nextToken()));
                num.get(i).setX(Integer.parseInt(st.nextToken()));
            }

            for(int i=0;i<N;i++) {

            }

            System.out.printf("#%d", t);
            t++;
        }

    }

}
