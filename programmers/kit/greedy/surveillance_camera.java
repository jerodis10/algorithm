package programmers.kit.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class surveillance_camera {
	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		String s = "4177252841";
//		int k = 4;
//		System.out.println(solution(s, k));
//		
//	}
	
	public int solution(int[][] routes) {
		
		int result = 0;
		
		Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int cam = Integer.MIN_VALUE;
		
		for(int[] route : routes) {
			if(cam < route[0]) {
				cam = route[1];
				result++;
			}
		}
		
		return result;
	}
}
