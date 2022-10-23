package Baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1300_binarySearch6 { 
	
	 public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
 
        long left = 1, right = K;
        long ans = 0;
        
        // 이분 탐색 수행
        while (left <= right) {
            long mid = (left + right) / 2; // 임의의 수 지정
            long cnt = 0;
            
            // mid보다 작거나 같은 수는 몇 개인지 계산.
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
 
            if (cnt < K) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
 
        System.out.println(ans);
    }
}
