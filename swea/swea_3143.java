package swea;

import java.util.Scanner;

public class swea_3143 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t = 1; t <= tc; t++) {
            String a = sc.next();
            String b = sc.next();
            int cnt = 0;
            int i = 0;
            while(i < a.length()) {
                if(i < a.length() - b.length() + 1) {
                    String tmp = a.substring(i, i+b.length());
                    if(tmp.equals(b)) i += b.length();
                    else i++;
                }
                else i++;
                cnt++;
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}
