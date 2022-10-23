package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class secret_map {

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] s1 = new String[n];
		String[] s2 = new String[n];
		String[] answer = new String[n];
		
		for(int i=0;i<arr1.length;i++) {
			String binNum = Integer.toString(arr1[i], 2);  
			if(binNum.length() == n) s1[i] = binNum;
			else {
				String s = "";
				for(int j=0;j<n-binNum.length();j++) {
					s += "0";
				}
				s1[i] = s + binNum;
			}
		}
		for(int i=0;i<arr2.length;i++) {
			String binNum = Integer.toString(arr2[i], 2);  
			if(binNum.length() == n) s2[i] = binNum;
			else {
				String s = "";
				for(int j=0;j<n-binNum.length();j++) {
					s += "0";
				}
				s2[i] = s + binNum;
			}
		}
		
		for(int i=0;i<s1.length;i++) {
			String str = "";
			for(int j=0;j<s1[i].length();j++) {
				if(s1[i].charAt(j) == '1' || s2[i].charAt(j) == '1') {
					str += "#";
				}
				if(s1[i].charAt(j) == '0' && s2[i].charAt(j) == '0') {
					str += " ";
				}
			}
			answer[i] = str;
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5,
				new int[] {9, 20, 28, 18, 11},
				new int[] {30, 1, 21, 17, 28}
		)).isEqualTo(new String[] {"#####","# # #", "### #", "#  ##", "#####"});
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				6,
				new int[] {46, 33, 33 ,22, 31, 50},
				new int[] {27 ,56, 19, 14, 14, 10}
		)).isEqualTo(new String[] {"######", "###  #", "##  ##", " #### ", " #####", "### # "});
	}
	
}
