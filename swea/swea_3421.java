package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_3421 {

    static int T;
    static int N;
    static int M;
    static int num[];
    static int except[][];
    static int temp[];
    static int ret;

    public static class Combination {
        private int n;
        private int r;
        private int[] now;
        private ArrayList<ArrayList<Integer>> result;

        public ArrayList<ArrayList<Integer>> getResult() {
            return result;
        }

        public Combination(int n, int r) {
            this.n=n;
            this.r=r;
            this.now = new int[r];
            this.result = new ArrayList<ArrayList<Integer>>();
        }

        public void combination(int[] arr, int depth, int index, int target) {
            if(depth==r) {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i=0;i<now.length;i++) {
                    temp.add(arr[now[i]]);
                }
                for(int j=0;j<M;j++) {
                    if(temp.contains(except[j][0]) && temp.contains(except[j][1])) {
                        return;
                    }
                }
//				result.add(temp);

                ret++;
                return;
            }
//			if(target==n) return;
            now[index]=target;
            combination(arr, depth+1, index+1, target+1);
            combination(arr, depth, index, target+1);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            int t = 1;
            ret = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            except = new int[M][2];
            num = new int[N];
            for(int i=0;i<N;i++) {
                num[i] = i + 1;
            }
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                except[i][0] = Integer.parseInt(st.nextToken());
                except[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i=2;i<=N;i++) {
                Combination comb = new Combination(num.length, i);
                comb.combination(num, 0, 0, 0);
            }

            System.out.printf("#%d %d", t, ret);
            t++;
        }

    }

}
