package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class ex {

	class FruitBox {
//		public void method(List<? extends Fruit> item) {
//			// 저장은 NO
//			item.add(new Fruit()); // ! ERROR
//			item.add(null); // null 만 삽입 가능
//		}

		void method(List<? super Fruit> item) {
			// 저장은 무조건 Fruit와 그의 자손 타입만 넣을수 있다
			item.add(new Fruit());
			item.add(new Apple());
			item.add(new Banana());

//			item.add(new Object()); // ! ERROR
//			item.add(new Food()); // ! ERROR
		}
	}

	// 타입 계층 관계
	class Food {
	}

	class Fruit extends Food {
	}

	class Vegetable extends Food {
	}

	class Apple extends Fruit {
	}

	class Banana extends Fruit {
	}

	class Carrot extends Vegetable {
	}


	public static void main(String[] args) {

	}



//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				Arrays.asList(1,5,7,6)
//		)).isEqualTo(5);
//	}
//
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				Arrays.asList(5,15,19)
//		)).isEqualTo(13);
//	}
//
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				Arrays.asList(10,3,5,7)
//		)).isEqualTo(10);
//	}
//
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				Arrays.asList(3,8,11,7)
//		)).isEqualTo(8);
//	}



}
