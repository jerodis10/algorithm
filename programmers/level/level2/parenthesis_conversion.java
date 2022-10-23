package programmers.level.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class parenthesis_conversion {

	public String solution(String p) {
		String answer = "";
		
		answer = splitStr(p);
		
		return answer;
    }
	
	public String splitStr(String pStr) {
		if(pStr.length() == 0) return "";
		if(checkStr(pStr)) return pStr;

		int leftCnt = 0;
		int rightCnt = 0;
		List<String> strList = new ArrayList<>();
		String[] strArr = pStr.split("");
		for(String str : strArr) {
			if(strList.size() > 0 && strList.size() % 2 == 0 && leftCnt == rightCnt) 
				break;
			
			if(str.equals("(")) leftCnt++;
			if(str.equals(")")) rightCnt++;
			
			strList.add(str);
		}
		
		String u = pStr.substring(0, leftCnt+rightCnt);
		String v = pStr.substring(leftCnt+rightCnt, pStr.length());
		
		if(!checkStr(u)) {
			return "(" + splitStr(v) + ")" + reverse(u);
		} else {
			v = splitStr(v);
		}

		return u + v;
	}

	public boolean checkStr(String str){
		int open = 0;
		if(str.charAt(0) ==')') return false;
		for(int i =0;i<str.length();i++){
			if(str.charAt(i) == '(') open++;
			else {
				open--;
				if(open<0) return false;
			}
		}
		return true;
	}
	
	public String reverse(String str){
		StringBuilder s = new StringBuilder();

		for(int i = 1; i<str.length()-1;i++){
			if(str.charAt(i) == '(') s.append(")");
			else s.append("(");
		}

		return s.toString();
	}
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"(()())()"
		)).isEqualTo(
				"(()())()"
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				")("
		)).isEqualTo(
				"()"
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"()))((()"
		)).isEqualTo(
				"()(())()"
		);
	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				10,
//				new int[] {0,0,0,0,0,0,0,0,3,4,3}
//		)).isEqualTo(
//				new int[] {1,1,1,1,1,1,1,1,0,0,2}
//		);
//	}
}
