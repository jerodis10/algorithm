package Baekjoon.binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805_binarySearch4 { 

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		
		int min = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			/*
			 * ������ �� �ִ��� ���ϱ� ���� �� �Է� ������ max ������ ���Ͽ�
			 * �Է� ���� ������ max���� Ŭ ��� max ���� �ش� ������ ���̷� �������ش�. 
			 */
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		// �̺� Ž�� (upper bound)
		while(min < max) {
			
			int mid = (min + max) / 2;
			long sum = 0;
			for(int treeHeight : tree) {
				
				/*
				 *  tree�� �߸� ���� = tree�� ���� - �ڸ��� ��ġ(mid)
				 *  tree�� �߸� ������ ���� ���Ѵ�.
				 *  �� �� �ڸ��� ��ġ�� �־��� ������ ���̺��� Ŭ �� �ֱ� ������
				 *  0 ������ ���(=����)���� �ջ��� ���� �ʰ� ����� �ջ��ϵ��� �ؾ��Ѵ�.
				 */
				if(treeHeight - mid > 0) { 
					sum += (treeHeight - mid);
				}
			}
			
 
			/*
			 * �ڸ� ���� ������ ���� M���� �۴ٴ� ����
			 * �ڸ��� ��ġ(����)�� ���ٴ� �ǹ��̹Ƿ� ���̸� ����� �Ѵ�.
			 * ��, ����(max)�� �ٿ��� �Ѵ�.
			 */
			if(sum < M) {
				max = mid;
			}
			
			/*
			 * �ڸ� ���� ������ ���� M���� ũ�ٴ� ����
			 * �ڸ��� ��ġ(����)�� ���ٴ� �ǹ��̹Ƿ� ���̸� ������ �Ѵ�.
			 * ����, ���� ��쿡�� �ִ��� ���� �ڸ��� ���� �ڸ��� ���̸�
			 * ������ �ϹǷ� ����(min)�� �÷��� �Ѵ�.
			 */
			else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
		
	}
}
