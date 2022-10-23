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
 
		int T = Integer.parseInt(br.readLine());	// �׽�Ʈ ���̽� 
 
		while (T -- > 0) {
			
			int[] table = new int[MOD];
			
			int N = Integer.parseInt(br.readLine());	// �Է¹޴� ���� ����
			
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				st.nextToken();	// �� �̸��� �ʿ� ���� 
				
				table[hash(st.nextToken())]++;	// �� ���� 
			}
 
			int result = 1;
 
			/**
			 * �� �Դ� ��츦 ����Ͽ� �� ������ ���� ������ +1 ���� ����
			 * �����־�� �Ѵ�.
			 */
			for (int val : table) {
				result *= (val + 1);
			}
			result--;		// �˸��� ���¸� �������־�� �ϹǷ� �������� -1�� ����.
			sb.append(result).append('\n');	
			table = null;
		}
		System.out.println(sb);
	}
	
	static int hash(String s) {
		return Math.abs(s.hashCode() ^ (s.hashCode() >>> 16)) % MOD;
	}
		
}
