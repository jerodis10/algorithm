package Baekjoon.queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1021_queue_deque6 {
	
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count = 0;	// 2, 3�� ���� Ƚ�� ���� �� ����
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// ť�� ũ��(1 ~ N)
		int M = Integer.parseInt(st.nextToken());	// �������� ������ ����
		
		// 1���� N���� ���� ��Ƶд�.
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int[] seq = new int[M];	// �̰��� �ϴ� ���� ���� �迭
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < M; i++) {
			
			
			// ������ �̰��� �ϴ� ������ ��ġ(index) ã�� 
			int target_idx = deque.indexOf(seq[i]);
			int half_idx;
			/*
			 *  ���� ���� ���� ���Ұ� ¦�� ����� �߰� ������ 
			 *  ���� ���� ���� ũ�⿡�� -1 ���ҽ�Ų��. 
			 *  
			 *  {1, 2, 3, 4} �� ��, 2�� �߰��������� �ϸ�
			 *  �ε����� 1�̱� ����
			 */
			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			}
			else {
				half_idx = deque.size() / 2;
			}
			
			
			// �߰� ���� �Ǵ� �߰� �������� ������ ��ġ�� �տ� ���� ���
			if(target_idx <= half_idx) {
				// idx ���� �տ� �ִ� ���ҵ��� ��� �ڷ� ������. (2�� ����)
				for(int j = 0; j < target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}
			else {	// �߰� �������� ������ ��ġ�� �ڿ� �ִ� ��� 
				// idx�� ������ �ڿ� �ִ� ���ҵ��� ��� ������ ������. (3�� ����)
				for(int j = 0; j < deque.size() - target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			
			}
			deque.pollFirst();	// ������ ������ �� �� ���Ҹ� ����
		}
		
		System.out.println(count);
		
		
	}
		
}
