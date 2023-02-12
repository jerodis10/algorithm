package kakao;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex3 {


	public static int solution(List<Integer> box) {
//		Collections.sort(box);
//		long left = box.get(0);
		long left = 1;
		long sum = 0;
		for(int i : box) sum += i;
		long right = sum;
		long ret = 0;

		while (left < right) {
			long mid = (left + right) / 2;
			long key = 0;
//			long max = maxNum(box);
//			if (mid > max) key = mid;
//			else {
			List<Long> temp = new ArrayList<>();
			for(long i : box) temp.add(i);
			for (int i = temp.size() - 1; i >= 1; i--) {
				long num = temp.get(i);
				if (num > mid) {
					temp.set(i, mid);
					temp.set(i - 1, temp.get(i - 1) + (num - mid));
				}
			}
			key = maxNum(temp);

			if (key <= mid) {
				right = mid;
			} else if(key > mid) {
				left = mid + 1;
			}
//			else {
//				ret = mid;
//				break;
////				return (int) left;
//			}
		}

//		return (int) ret;
		return (int) left;
	}


	public static long maxNum (List <Long> list) {
		long max = Long.MIN_VALUE;
		for (long n : list) max = Math.max(max, n);
		return max;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				Arrays.asList(1,5,7,6)
		)).isEqualTo(5);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				Arrays.asList(5,15,19)
		)).isEqualTo(13);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				Arrays.asList(10,3,5,7)
		)).isEqualTo(10);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				Arrays.asList(3,8,11,7)
		)).isEqualTo(8);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				Arrays.asList(3,5,110,7)
		)).isEqualTo(40);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				Arrays.asList(100000000,200000000,300000000,400000000)
		)).isEqualTo(250000000);
	}

	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				Arrays.asList(1000000000,1000000000,1000000000,1000000000)
		)).isEqualTo(1000000000);
	}



}
