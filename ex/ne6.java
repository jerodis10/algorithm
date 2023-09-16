package ex;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ne6 {

	public static void main(String[] args) {
		System.out.println(totalTriplets(List.of(1,3,5,3,5), 15)); // 4
		System.out.println(totalTriplets(List.of(1,2,2,2,4), 8)); //3
		System.out.println(totalTriplets(List.of(6,1,-3,9,3,-9, -1, -27), -27)); // 4
		System.out.println(totalTriplets(List.of(0,1,3,5), 0)); // 3
		System.out.println(totalTriplets(List.of(2500, -2500, 10000, 10, 200), 10000000000L)); // 2
	}

	public static long totalTriplets(List<Integer> capacity, long desiredCapacity) {
		Map<Integer, Integer> postMap = new HashMap<>();
		Map<Integer, Integer> preMap = new HashMap<>();

		for (int i=2; i<capacity.size(); i++) {
			int c = capacity.get(i);
			postMap.put(c, postMap.getOrDefault(c, 0) + 1);
		}

		long answer = 0;
		for (int i=1; i<capacity.size(); i++) {
			long a = capacity.get(i-1);
			long b = capacity.get(i);

			long product = a * b;

			if (product == 0) {
				if (desiredCapacity == 0) {
					answer += getSum(preMap, postMap);
				}
			}
			else if (desiredCapacity % product != 0) {
			}
			else {
				long tmp = desiredCapacity / product;

				if (tmp >= -100000 && tmp <= 100000) {
					int v = (int) tmp;

					answer += postMap.getOrDefault(v, 0);
					answer += preMap.getOrDefault(v, 0);
				}
			}

			if (i + 1 < capacity.size()) {
				postMap.put(capacity.get(i+1), postMap.get(capacity.get(i+1)) - 1);
			}


			if (i - 2 >= 0) {
				preMap.put(capacity.get(i - 2), preMap.getOrDefault(capacity.get(i-2), 0) + 1);
			}
		}

		return answer;
	}

	private static int getSum(Map<Integer, Integer> preMap, Map<Integer, Integer> postMap) {
		int sum = 0;
		for (int n: preMap.keySet()) {
			sum += preMap.get(n);
		}

		for (int n: postMap.keySet()) {
			sum += postMap.get(n);
		}

		return sum;
	}

}
