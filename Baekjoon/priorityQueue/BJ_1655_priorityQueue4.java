package Baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_1655_priorityQueue4 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
        	else minHeap.offer(num);
        	
        	if(!minHeap.isEmpty() && !maxHeap.isEmpty())
        		if(minHeap.peek() < maxHeap.peek()) {
        			int temp = minHeap.poll();
        			minHeap.offer(maxHeap.poll());
        			maxHeap.offer(temp);
        		}
        	sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb);
	}
}
