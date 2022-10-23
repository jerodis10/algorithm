package programmers.kit.stack_queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class truck_crossing_the_bridge {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int a = 2;
//		int[] b = {7,4,5,6};
//		int c = 8;
		
		int a = 100;
		int[] b = {10};
		int c = 100;
		
		int ret = solution(a, c, b);
		
		System.out.println(ret);
	}
	

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int sum = 0;

        for(int truck : truck_weights) {
        	while(true) {
        		if(q.isEmpty()) {
        			q.add(truck);
        			sum += truck;
        			time++;
        			break;
        		} else if(q.size() == bridge_length) {
        			sum -= q.poll();
        		} else {
        			if(sum + truck <= weight) {
						q.add(truck);
						sum += truck;
						time++;
						break;
					} else { 
						q.add(0);
						time++;
					}
        		}
        	}
        }
        
        return time + bridge_length;
	}
}
