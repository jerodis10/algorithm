package Baekjoon.num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3036_num6 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		int N = Integer.parseInt(br.readLine());
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		// ù ��° ��
		int firstRing = Integer.parseInt(st.nextToken());
 
		for (int i = 1; i < N; i++) {
			
			int otherRing = Integer.parseInt(st.nextToken());
			
			// ���м��� ����� ���� �ִ����� ã��
			int gcd = gcd(firstRing, otherRing);
 
			// �и�� ���ڸ� �ִ������� �����ֱ� 
			sb.append(firstRing / gcd).append('/').append(otherRing / gcd).append('\n');
		}
		
		System.out.println(sb);
 
	}
 
	// �ִ����� �޼ҵ�
	static int gcd(int a, int b) {
		int r;
 
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
		
}
