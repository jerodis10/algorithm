//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class ex {
//
//    int number = 6;
//    int max = Integer.MAX_VALUE;
//    ArrayList<ArrayList<int[]>> edge = new ArrayList<>();
//    int[] vertext = new int[7];
//
//    void dijkstra() {
//        vertext[start] = 0;
//        PriorityQueue<int[]> pq = new PriorityQueue<>();
//        pq.add(new int[]{start, 0});
//
//        while (!pq.isEmpty()) {
//            int current = pq.peek()[0];
//            int distance = pq.peek()[1];
//            pq.poll();
//
//            if(vertex[current] < distance) continue;
//
//            for (int i = 0; i < edge.get(current).size(); i++) {
//                int next = edge.get(current).get(i)[0];
//                int nextDistance = edge.get(current).get(i)[1];
//                if (nextDistance < vertex[next]) {
//                    vertex[next] = nextDistance;
//                    pq.add()
//                }
//
//            }
//        }
//    }
//
//
//
//	int number = 6;
//    int max = Integer.MAX_VALUE;
//    ArrayList<ArrayList<int[]>> edge = new ArrayList<>();
//    int[] vertex = new int[7];
//
//    void dijkstra(int start) {
//        vertex[start] = 0;
//        PriorityQueue<int[]> pq = new PriorityQueue<>();
//        pq.add(new int[]{start, 0});
//
//        while (!pq.isEmpty()) {
//            int current = pq.peek()[0];
//            int distance = pq.peek()[1];
//            pq.poll();
//
//            if(vertex[current] < distance) continue;
//            for (int i = 0; i < edge.get(current).size(); i++) {
//                int next = edge.get(current).get(i)[0];
//                int nextDistance = distance + edge.get(current).get(i)[1];
//                if (nextDistance < vertex[next]) {
//                    vertex[next] = nextDistance;
//                    pq.add(new int[]{next, nextDistance});
//                }
//            }
//        }
//    }
//
////	@Test
////	public void testCase() {
////		Assert.assertEquals("ABCxyZA", solution("xyZA", "ABCxy"));
//////		Assert.assertEquals(1, solution(new int[][] {{1,1,0}, {1,1,1}, {0,1,1}}));
////	}
//
//
//}
