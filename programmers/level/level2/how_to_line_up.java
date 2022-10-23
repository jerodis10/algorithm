package programmers.level.level2;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class how_to_line_up {

	public int[] solution(int n, long k) {
		int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1;

        while (i < n) {
            factorial = factorial / (n - i);
            int v = (int) (remain / factorial);
            answer[i++] = list.get(v);
            list.remove(v);
            remain = remain % factorial;
        }

        return answer; 
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3,
				5
		)).isEqualTo(
				new int[] {3,1,2}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5,
				10
		)).isEqualTo(
				new int[] {1,3,4,5,2}
		);
	}
	
}
