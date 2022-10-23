package programmers.level.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class failure_rate {

	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] fail_num = new int[N+2];
		int left_num = stages.length;
		ArrayList<Fail> failure_list = new ArrayList<>();
		
		for(int i=0; i<stages.length; i++) {
			fail_num[stages[i]]++;
		}
		
		for(int i=1; i<=N; i++) {
			if(fail_num[i] == 0) {
				failure_list.add(new Fail(i, 0));
			} else {
				failure_list.add(new Fail(i, (double) fail_num[i] / left_num));
			}
			left_num -= fail_num[i];
		}
		
		Collections.sort(failure_list, new Comparator<Fail>() {
			@Override
			public int compare(Fail o1, Fail o2) {
				if(o1.getFail_rate() == o2.getFail_rate()) {
					return o1.getNum() - o2.getNum();
				} else {
					return Double.compare(o2.getFail_rate(), o1.getFail_rate());
				}
			}
		});
		
		for(int i=0; i<failure_list.size(); i++) {
			answer[i] = failure_list.get(i).getNum();
		}
		
		return answer;
    }
	
	public class Fail {
		private int num;
		private double fail_rate;
		
		public Fail(int num, double fail_rate) {
			super();
			this.num = num;
			this.fail_rate = fail_rate;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public double getFail_rate() {
			return fail_rate;
		}
		public void setFail_rate(double fail_rate) {
			this.fail_rate = fail_rate;
		}
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5,
				new int[] {2, 1, 2, 6, 2, 4, 3, 3}
		)).isEqualTo(new int [] {3,4,2,1,5});
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,
				new int[] {4,4,4,4,4}
		)).isEqualTo(new int [] {4,1,2,3});
	}
	
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				8,
				new int[] {1,2,3,4,5,6,7}
		)).isEqualTo(new int [] {7, 6, 5, 4, 3, 2, 1, 8});
	}
	
}
