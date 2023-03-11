import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class ex {


	public static int solution(List<Integer> box) {
//		Collections.sort(box);
//		long left = box.get(0);
		long left = 1;
		int sum = 0;
		for(int i : box) sum += i;
		long right = sum;
		long ret = 0;

		while (left < right) {
			long mid = (left + right) / 2;
			long key = 0;
//			long max = maxNum(box);
//			if (mid > max) key = mid;
//			else {
			List<Integer> temp = new ArrayList<>();
			for(int i : box) temp.add(i);
			for (int i = temp.size() - 1; i >= 1; i--) {
				int num = temp.get(i);
				if (num > mid) {
					temp.set(i, (int) mid);
					temp.set(i - 1, temp.get(i - 1) + (num - (int) mid));
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


	public static int maxNum (List <Integer> list) {
		int max = Integer.MIN_VALUE;
		for (int n : list) max = Math.max(max, n);
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



}
