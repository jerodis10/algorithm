package programmers.kit.sort;

import java.io.IOException;
import java.util.Arrays;

public class h_index {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] a = {3, 0, 6, 1, 5};
		
		System.out.println(solution(a));
	}
	

	public static int solution(int[] citations) {
		int answer = 0;
        Arrays.sort(citations);
 
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
 
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
 
        return answer;
	}
}
