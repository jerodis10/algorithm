package programmers.kit.greedy;

import java.io.IOException;

public class make_big_numbers {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String s = "4177252841";
		int k = 4;
		System.out.println(solution(s, k));
		
	}
	
	public static String solution(String number, int k) {
		
		StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    	
	}
}
