package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p6 {

	public long getMaxProfit(List<Integer> pnl, int k) {
		// Write your code here

		ArrayList<Integer> rs = new ArrayList<>();
		rs.add(pnl.get(0));

		for (int i = 1 ; i < pnl.size(); i++) {
			int lower = lowerBound(pnl, 0, rs.size(), pnl.get(i));
			if(rs.size() <= lower) rs.add(pnl.get(i));
			else rs.set(lower, pnl.get(i));
		}

		return arrSum(rs);
	}

	public int lowerBound(List<Integer> arr, int left, int right, int key) {
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr.get(mid) < key) left = mid + 1;
			else right = mid;
		}

		return right;
	}

	public long arrSum(ArrayList<Integer> arr) {
		long sum = 0;
		for (int num : arr) {
			sum += num;
		}

		return sum;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(getMaxProfit(
				List.of(4,3,-2,9,-4,2,7),
				6
		)).isEqualTo(
				15
		);
	}


}
