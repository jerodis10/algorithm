package programmers.level.level2;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Repeat_Binary_Transformation {
	
	public int[] solution(String s) {
        int[] answer = new int[2];
		List<String> str_list = new ArrayList<>();
		String[] str_arr = {};
		
		while(!s.equals("1")) {
			str_arr = s.split("");
			str_list = new ArrayList<>();
			for(int i=0;i<str_arr.length;i++)
				if(str_arr[i].equals("1"))
					str_list.add(str_arr[i]);
				else 
					answer[1]++;
			
			int len = str_list.size();
			s = Integer.toString(len, 2);
			answer[0]++;
		}
		
		return answer;
    }
	
//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				3,
//				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
//		)).isEqualTo(
//				50
//		);
//	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				3,
//				new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}
//		)).isEqualTo(
//				21
//		);
//	}
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				2,
//				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
//		)).isEqualTo(
//				60
//		);
//	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				5,
//				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
//		)).isEqualTo(
//				52
//		);
//	}
//	@Test
//	public void testCase5() {
//		Assertions.assertThat(solution(
//				2,
//				new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}
//		)).isEqualTo(
//				16
//		);
//	}
//	@Test
//	public void testCase6() {
//		Assertions.assertThat(solution(
//				0,
//				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
//		)).isEqualTo(
//				25
//		);
//	}
	
//	@Test
//	public void testCase7() throws ParseException {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//		Date date = formatter.parse("20220502");
//		Calendar getToday = Calendar.getInstance(); 
//		getToday.setTime(new Date()); //금일 날짜
//		Calendar cmpDate = Calendar.getInstance();
//		cmpDate.setTime(date);
//		long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
//		long diffDays = diffSec / (24*60*60);
//		
//		System.out.println(diffDays);
//	}
}
