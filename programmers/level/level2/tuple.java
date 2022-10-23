package programmers.level.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class tuple {

	public int[] solution(String s) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		s = s.substring(2,s.length());
		s = s.substring(0,s.length()-2).replace("},{","-");
		String str[] = s.split("-");
		Arrays.sort(str,new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
		
		for(String x : str) {
			String[] temp = x.split(",");
			for(int i = 0 ; i < temp.length;i++){
				int n = Integer.parseInt(temp[i]);
				if(!answer.contains(n))
					answer.add(n);
			}
		}
		
		return answer.stream().mapToInt(i -> i).toArray();
		
    }
	
	
//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				5,
//				new int[] {2,1,1,1,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {0,2,2,0,1,0,0,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				1,
//				new int[] {1,0,0,0,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {-1}
//		);
//	}
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				9,
//				new int[] {0,0,1,2,0,1,1,1,1,1,1}
//		)).isEqualTo(
//				new int[] {1,1,2,0,1,2,2,0,0,0,0}
//		);
//	}
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
