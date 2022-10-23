package programmers.kit.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class arithmetic_operation {
	
	int max;
	
	public int solution(String arr[]) {
		List<Integer> num = new ArrayList<>();
		List<String> cal = new ArrayList<>();
		max = Integer.MIN_VALUE;
		
		for(String str : arr) {
			if(arr.equals("+") || arr.equals("-")) {
				cal.add(str);
			} else {
				num.add(Integer.parseInt(str));
			}
		}
		
//		combNum(num);
		

		return 0;
	}
	
	public void combNum() {
		
	}


}
