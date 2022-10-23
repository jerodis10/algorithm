package programmers.level.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class parking_fee_calculation {
	
	public int[] solution(int[] fees, String[] records) {
        int lastTime = getMin("23:59");
        // 현재 파킹 중인 차들
		Map<String, Integer> parking = new HashMap<>();
        // 차들의 누적 파킹시간
		Map<String, Integer> times = new HashMap<>();
        // 차들 list
		List<String> cars = new ArrayList<>();
		
		for(String record : records) {
			String[] rc = record.split(" ");
			int time = getMin(rc[0]);
			String car = rc[1];
			
            // 새로운차 등장
			if(!cars.contains(car)) {
				cars.add(car);
				times.put(car, 0);
			}
			
			if(parking.containsKey(car)) {
            	// 현재 파킹이 되어 있다면 출차다
				times.put( car, times.get(car)+(time-parking.get(car)) );
				parking.remove(car);
			} else {
            	// 파킹이 안되어 있다면 입차다.
				parking.put(car, time);
			}
			
		}
		
		int[] ret = new int[cars.size()];
        	// 차번 순으로 정렬
		Collections.sort(cars);
		
		for(int i=0 ; i<cars.size() ; i++) {
        		// 기본요금
			ret[i] = fees[1];
			String car = cars.get(i);
            		// 누적시간중 기본요금 시간 제외
			int time = times.get(car)-fees[0];
            		// 아직 출차가 안되었다면 마지막시간으로 정산
			if(parking.containsKey(car)) time += (lastTime-parking.get(car));
            		// 요금 정산
			if(time>0) ret[i] += (Math.ceil(time/(fees[2]*1.0))*fees[3]);
		}
		
		return ret;
    }
    
    // Convert time String to Integer
    public int getMin(String time) {
		String[] t = time.split(":");
		return Integer.valueOf(t[0])*60+Integer.valueOf(t[1]);
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {180, 5000, 10, 600},
				new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
						"07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT",
						"22:59 5961 IN", "23:00 5961 OUT"
				}
		)).isEqualTo(
				new int[] {14600, 34400, 5000}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {120, 0, 60, 591},
				new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT",
						"18:00 0202 OUT","23:58 3961 IN"
				}
		)).isEqualTo(
				new int[] {0, 591}
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[] {1, 461, 1, 10},
				new String[] {"00:00 1234 IN"}
		)).isEqualTo(
				new int[] {14841}
		);
	}
	
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(
//				Integer.parseInt("05")
//		).isEqualTo(
//				5
//		);
//	}
}
