package programmers.kit.heap;

import java.io.IOException;
import java.util.PriorityQueue;

public class disk_controller {

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
	

	public int solution(int[][] jobs) {
		
		// 대기열 → '작업이 요청되는 시점'이 빠른 순으로 정렬되는 우선순위 큐
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		
		for(int[] job : jobs){
            q.offer(job);
        }
		
		// 작업 큐 → '작업이 소요시간'이 적은 순으로 정렬되는 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		int count = 0;
        int sum = 0;
        int time = 0;
        
     // 모든 작업이 끝날때까지 while문 반복
        while(count < jobs.length){
            // 1ms마다 while문 반복
            // 작업 큐에 추가 (대기열이 비어있지 않고 요청 시점이 되었을 때 추가)
            while(!q.isEmpty() && time >= q.peek()[0]){
                pq.offer(q.poll());
            }
            // 작업 큐에 작업이 있으면 우선순위에 따라 작업 진행
            if(!pq.isEmpty()){
                int[] j = pq.poll();
                sum += j[1] + (time - j[0]);
                time += j[1];
                count++;
            }
            else {  // 작업이 없으면 시간 1ms 흐름
                time++;
            }            
        }
        
        // 작업의 요청부터 종료까지 걸린 시간의 평균 리턴
        return sum / count;
	}
}
