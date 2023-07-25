package programmers.kakao_blind_2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol4 {

	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];

		for(int i = 0; i<numbers.length; i++) {
			String binaryTree = getBinaryTree(numbers[i]);
			if (checkTree(binaryTree)) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}
		return answer;
	}

	// 이진수 변환작업, 이진수의 길이가 포화트리보다 작다면 숫자를 변형시키지 않도록 앞에만 0을 붙인다
	private String getBinaryTree(long number) {
		String binary = Long.toBinaryString(number);
		int height = (int) Math.ceil(Math.log10(binary.length() + 1) / Math.log10(2));
		int size = (int) Math.pow(2, height) - 1;

		int dummy = size - binary.length();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dummy; i++) {
			sb.append("0");
		}

		sb.append(binary);
		return sb.toString();
	}

	// 더미노드는 1인 자식을 가질 수 없다.
	private boolean checkTree(String binaryTree) {
		if (binaryTree.length() <= 1) {
			return true;
		}

		String leftTree = binaryTree.substring(0, binaryTree.length() / 2);
		String rightTree = binaryTree.substring(binaryTree.length() / 2 + 1);


		char root = binaryTree.charAt(binaryTree.length() / 2);
		char left = leftTree.charAt(leftTree.length() / 2);
		char right = rightTree.charAt(rightTree.length() / 2);

		if (root == '0' && (left == '1' || right == '1') )
			return false;
		else
			return checkTree(leftTree) && checkTree(rightTree);
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new long[]{7,42,5}
		)).isEqualTo(
				new int[]{1,1,0}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new long[]{63,111,95}
		)).isEqualTo(
				new int[]{1,1,0}
		);
	}


}
