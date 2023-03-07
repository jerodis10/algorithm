import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person {
	int del;
	int fo;

	public Person(int del, int fo) {
		this.del = del;
		this.fo = fo;
	}
}

public class ex4 {

	static final int MOD = 1_000_000_007;

	public static int solution(int n, int delay, int forget) {
		int answer = 0;

		int day = 1;
		List<Person> list = new ArrayList<>();
		list.add(new Person(delay, forget));
		while (day < n) {
			day++;
			int add = 0;
			List<Person> deleteList = new ArrayList<>();
			int index = 0;
			for (Person p : list) {
				if (p.del > 0) {
					p.del--;
					p.fo--;
					if (p.del == 0 && p.fo > 0) {
						add++;
					}
				} else {
					if (p.fo > 0) {
						p.fo--;
						if(p.fo > 0) add++;
						else deleteList.add(p);
					} else {
						deleteList.add(p);
					}
				}
				index++;
			}

			for (int i = 0; i < add; i++) {
				list.add(new Person(delay, forget));
			}
			for (int i = 0; i < deleteList.size(); i++) {
				list.remove(deleteList.get(i));
			}
		}

		return list.size() % MOD;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6,2,4
		)).isEqualTo(5);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,1,3
		)).isEqualTo(6);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				500,2,4
		)).isEqualTo(6);
	}

//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				4,4,6
//		)).isEqualTo(7);
//	}


}
