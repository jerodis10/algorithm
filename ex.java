//import java.util.LinkedList;
//import java.util.Queue;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class ex {
//
//	int result;
//    boolean[] visited;
//
//	public String solution(String s1, String s2) {
//		String answer = "";
//
//		char[] charArr1 = s1.toCharArray();
//		char[] charArr2 = s2.toCharArray();
//
//		int index = 0;
//		for(int i = charArr1.length; i >= 0; i--) {
//			if(charArr1[i] == charArr2[index]) {
//				index++;
//			} else {
//				index--;
//				break;
//			}
//		}
//
//		answer += s1.subString(0, index);
//		answer += s2.subString(index, s2.length());
//
//		return answer;
//	}
//
//	@Test
//	public void testCase() {
//		Assert.assertEquals("ABCxyZA", solution("xyZA", "ABCxy"));
////		Assert.assertEquals(1, solution(new int[][] {{1,1,0}, {1,1,1}, {0,1,1}}));
//	}
//
//
//}
