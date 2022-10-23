package programmers.kit.stack_queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class printer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] a = {1, 1, 9, 1, 1, 1};
		int b = 0;
		
		int ret = solution(a, b);
		
		System.out.println(ret);
	}
	

	public static int solution(int[] priorities, int location) {
		
		class Task {
	        int location;
	        int priority;
	        public Task(int location, int priority) {
	            this.location = location;
	            this.priority = priority;
	        }
	    }
		
		int answer = 0;

        Queue<Task> queue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            queue.add(new Task(i, priorities[i]));
        }

        int now=0;
        while(!queue.isEmpty()){
            Task cur = queue.poll();
            boolean flag = false;
            for(Task t : queue){
                if(t.priority>cur.priority){
                    flag = true;
                }
            }
            if(flag) { // 우선순위 높은게 있으면 뒤로 보낸다
                queue.add(cur);
            }else{
                now++;
                if(cur.location == location) {
                    answer = now;
                    break;
                }

            }
        }
        return answer;
	}
}
