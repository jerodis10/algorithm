package Baekjoon.queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1966_queue_deque4 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// �׽�Ʈ ���̽� 
 
		while (T-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();	// Queue�� Ȱ�� �� ���Ḯ��Ʈ
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < N; i++) {
				// {�ʱ� ��ġ, �߿䵵}
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
 
			int count = 0;	// ��� Ƚ��
			
			while (!q.isEmpty()) {	// �� ���̽��� ���� �ݺ���
				
				int[] front = q.poll();	// ���� ù ����
				boolean isMax = true;	// front ���Ұ� ���� ū ���������� �Ǵ��ϴ� ����
				
				// ť�� �����ִ� ���ҵ�� �߿䵵�� �� 
				for(int i = 0; i < q.size(); i++) {
					
					// ó�� ���� ���Һ��� ť�� �ִ� i��° ���Ұ� �߿䵵�� Ŭ ��� 
					if(front[1] < q.get(i)[1]) {
						
						// ���� ���� �� i ������ ���ҵ��� �ڷ� ������.
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						// front���Ұ� ���� ū ���Ұ� �ƴϿ����Ƿ� false�� �ϰ� Ž���� ��ħ
						isMax = false;
						break;
					}
				}
				
				// front ���Ұ� ���� ū ���Ұ� �ƴϿ����Ƿ� ���� �ݺ������� �Ѿ
				if(isMax == false) {
					continue;
				}
				
				// front ���Ұ� ���� ū ���ҿ����Ƿ� �ش� ���Ҵ� ����ؾ��ϴ� ������.
				count++;
				if(front[0] == M) {	// ã���� �ϴ� ������� �ش� �׽�Ʈ���̽� ����
					break;
				}
 
			}
 
			sb.append(count).append('\n');
 
		}
		System.out.println(sb);
	}
		
}
