package programmers.level.level2;

import java.util.LinkedList;
import java.util.Queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class cash {
	
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Queue<String> cache = new LinkedList<>();
		
		if(cacheSize == 0) return cities.length * 5;
		
		for(String city : cities) {
			city = city.toUpperCase();
			
			if(cache.contains(city)) {
				answer += 1;
				cache.remove(city);
				cache.add(city);
			} else {
				answer += 5;
				if(cache.size() == cacheSize) {
					cache.poll();
				}
				cache.add(city);
			}
		}
		
		return answer;
   }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3,
				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
		)).isEqualTo(
				50
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3,
				new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}
		)).isEqualTo(
				21
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				2,
				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
		)).isEqualTo(
				60
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				5,
				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
		)).isEqualTo(
				52
		);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				2,
				new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}
		)).isEqualTo(
				16
		);
	}
	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				0,
				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
		)).isEqualTo(
				25
		);
	}
	
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
