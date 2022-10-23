package Baekjoon.num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609_num3 {
	
	static int num[]; //�Է¹��� ��
	static int num2[]; 
	static int num3[]; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
 
		int d = gcd(a, b);
 
		System.out.println(d);
		System.out.println(a * b / d);
 
	}
 
	// �ִ����� �ݺ��� ���
	public static int gcd(int a, int b) {
 
		while (b != 0) {
			int r = a % b; // �������� �����ش�.
 
			// GCD(a, b) = GCD(b, r)�̹Ƿ� ��ȯ�Ѵ�.
			a = b;
			b = r;
		}
		return a;
	}
	
}
