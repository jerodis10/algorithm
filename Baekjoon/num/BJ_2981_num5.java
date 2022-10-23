package Baekjoon.num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ_2981_num5 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		Arrays.sort(arr);	// ����
 
		int gcdVal = arr[1] - arr[0];	// ������ ���� �ʵ��� ū ������ ���� ���� ���ش�.
 
		for(int i = 2; i < N; i++) {
			// ������ �ִ� ������� ���� ��(arr[i] - arr[i - 1])�� �ִ������� ���� 
			gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
		}
 
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// �ִ������� ����� ã�� (�����ٱ����� Ž��)
		for(int i = 2; i <= Math.sqrt(gcdVal); i++) {
	    
			// �������� gcdVal�� ������ �ߺ��߰��� �����ϱ� ���� �� ���� �߰�
			if(i * i == gcdVal) {
				list.add(i);
			}
			// i�� �ִ������� ������ i�� ���� �� �߰� 
			else if(gcdVal % i == 0) {
				list.add(i);
				list.add(gcdVal / i);
			}
		}
 
		// ���� 
		Collections.sort(list);
		
		for(int val : list) {
			sb.append(val).append(' ');
		}
		// ������ �ִ����� �� ����ؾ���
		sb.append(gcdVal);
		System.out.println(sb);
		
	}
	
	// �ִ����� �Լ�
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
		
}
