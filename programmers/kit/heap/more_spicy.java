package programmers.kit.heap;

import java.io.IOException;
import java.util.PriorityQueue;

public class more_spicy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] a = {93, 30, 55};
		int[] b = {1, 30, 5};
		
//		int[] a = {95, 90, 99, 99, 80, 99};
//		int[] b = {1, 1, 1, 1, 1, 1};
		
//		int[] re = solution(a, b);
//		
//		for(int i=0;i<re.length;i++)
//			System.out.println(re[i]);
	}
	

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for(int item : scoville) heap.offer(item);
		
		while(heap.peek() <= K) {
			if(heap.size() == 1) return -1;
			
			heap.offer(heap.poll() + (heap.poll() * 2));
			answer++;
		}
		
        return answer;
	}
}
