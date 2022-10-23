package programmers.kit.stack_queue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class function_development {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] a = {93, 30, 55};
		int[] b = {1, 30, 5};
		
//		int[] a = {95, 90, 99, 99, 80, 99};
//		int[] b = {1, 1, 1, 1, 1, 1};
		
		int[] re = solution(a, b);
		
		for(int i=0;i<re.length;i++)
			System.out.println(re[i]);
	}
	

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<progresses.length;i++) {
			q.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
		}
		
		List<Integer> answer = new ArrayList<>();

		while(!q.isEmpty()) {
			int day = q.poll();
			int cnt = 1;
			
			while(!q.isEmpty() && day >= q.peek()){
				cnt++; 
				q.poll(); 
			}
			answer.add(cnt);

		}
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
