package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251_dynamicProgramming14 {
	
	static char[] str1;
	static char[] str2;
 
	static Integer[][] dp;
	
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
 
		
		dp = new Integer[str1.length][str2.length];
		
		System.out.println(LCS(str1.length - 1, str2.length - 1));
		
	}
	
	static int LCS(int x, int y) {
		
		// �ε��� �� (������)�� ��� 0 ��ȯ
		if(x == -1 || y == -1) {
			return 0;
		}
 
		// ���� Ž������ ���� �ε������?
		if(dp[x][y] == null) {
			dp[x][y] = 0;
 
			// str1�� x��° ���ڿ� str2�� y��° ���ڰ� ������ �˻�
			if(str1[x] == str2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			}
 
			// ���� �ʴٸ� LCS(dp)[x-1][y]�� LCS(dp)[x,y-1] �� ū ������ �ʱ�ȭ
			else {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}
		
		return dp[x][y];
	}
}
