package Baekjoon.num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9375_num10 {
	
public final static int MOD = 10007;
    
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 
 
		while (T -- > 0) {
			
			int[] table = new int[MOD];
			
			int N = Integer.parseInt(br.readLine());	// 입력받는 옷의 개수
			
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				st.nextToken();	// 옷 이름은 필요 없음 
				
				table[hash(st.nextToken())]++;	// 옷 종류 
			}
 
			int result = 1;
 
			/**
			 * 안 입는 경우를 고려하여 각 종류별 옷의 개수에 +1 해준 값을
			 * 곱해주어야 한다.
			 */
			for (int val : table) {
				result *= (val + 1);
			}
			result--;		// 알몸인 상태를 제외해주어야 하므로 최종값에 -1이 정답.
			sb.append(result).append('\n');	
			table = null;
		}
		System.out.println(sb);
	}
	
	static int hash(String s) {
		return Math.abs(s.hashCode() ^ (s.hashCode() >>> 16)) % MOD;
	}
		
}
