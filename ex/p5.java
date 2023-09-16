package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class p5 {

	public long getMaxBeauty(List<Integer> arr) {
		arr.sort(null);
		ArrayList<Object> objects = new ArrayList<>();
		objects.remove("");

		int[] arrangedArr = new int[arr.size()];

		int smallIdx = 0;
		int bigIdx = arr.size() / 2;

		for (int i=0; i<arrangedArr.length;) {
			if (i % 2 == 0) {
				arrangedArr[i] = arr.get(bigIdx);
				bigIdx++;
			} else {
				arrangedArr[i] = arr.get(smallIdx);
				smallIdx++;
			}
			i++;
		}

		long[] psum = new long[arrangedArr.length];
		psum[0] = arrangedArr[0];
		for (int i=1; i<psum.length; i++) {
			psum[i] = psum[i-1] + arrangedArr[i];
		}

		long answer = 0;
		for (int i=0; i<psum.length; i++) {
			if (i % 2 == 0) {
				answer += psum[i];
			} else {
				answer -= psum[i];
			}
		}
		return answer;



//		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
//		PriorityQueue<Integer> minPq = new PriorityQueue<>();
//		long sum = 0;
//		long result = 0;
//
//		for (int i = 0; i < arr.size(); i++) {
//			maxPq.add(arr.get(i));
//			minPq.add(arr.get(i));
//		}
//
//		for (int i = 0; i < arr.size() / 2; i++) {
//			sum += maxPq.poll();
//			result += sum;
//			sum += minPq.poll();
//			result -= sum;
//		}
//
//		if (maxPq.size() % 2 == 1) {
//			sum += maxPq.poll();
//			result += sum;
//		}
//
//		return result;
	}



	@Test
	public void testCase() {
		Assertions.assertThat(getMaxBeauty(
				List.of(4,1,2,4)
		)).isEqualTo(
				-3
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(getMaxBeauty(
				List.of(3,4,5,1,1)
		)).isEqualTo(
				12
		);
	}


}
