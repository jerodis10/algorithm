package programmers.level.level1;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class year_2016 {

	public String solution(int a, int b) {
		String[] day = {"MON", "TUE", "WED", "THU","FRI", "SAT","SUN"};
		
		int week = LocalDate.of(2016, a, b).getDayOfWeek().getValue();
		
	    return day[week-1];
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5,
				24
		)).isEqualTo("TUE");
	}
	
}
