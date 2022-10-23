package programmers.kit.sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class k_th_number {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] a = {1, 5, 2, 6, 3, 7, 4};
		int[][] b = {{2,5,3},{4,4,1},{1,7,3}};
		
//		int[] a = {95, 90, 99, 99, 80, 99};
//		int[] b = {1, 1, 1, 1, 1, 1};
		
//		int[] re = solution(a, b);
//		
//		for(int i=0;i<re.length;i++)
//			System.out.println(re[i]);
	}
	

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		answer = new int[commands.length];

		for(int i=0;i<commands.length;i++) {
			List<Integer> arr = new ArrayList<Integer>();
			for(int j=commands[i][0]-1;j<commands[i][1];j++) {
				arr.add(array[j]);
			}
			Collections.sort(arr);
			answer[i] = arr.get(commands[i][2]-1);

		}
		
		return answer;
	}
}
