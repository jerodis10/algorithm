package Baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927_priorityQueue2 {
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    //최대힙
//	    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
	    PriorityQueue<Integer> queue = new PriorityQueue<>();
	    for (int i = 0; i < N; i++) {
	        int n = Integer.parseInt(br.readLine());
	        if (n == 0) {
	            if (queue.isEmpty()) {
	                System.out.println(0);
	            } else {
	                System.out.println(queue.poll());
	            }
	        } else {
	            queue.offer(n);
	        }
	    }	
	}
}
