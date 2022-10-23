package programmers.level.level1;

import java.util.Scanner;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class rectangle_star {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int i=0;i<b;i++) {
			for(int j=0;j<a;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
    }
	
	
//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				new int[][] {{1,2}, {2,3}},
//				new int[][] {{3,4}, {5,6}}
//		)).isEqualTo(
//				new int[][] {{4,6}, {7,9}}
//		);
//	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				new int[][] {{1}, {2}},
//				new int[][] {{3}, {4}}
//		)).isEqualTo(
//				new int[][] {{4}, {6}}
//		);
//	}
	
	
}
