package ex;

import java.util.ArrayList;
import java.util.List;


public class ne5 {

	public static void main(String[] args) {
		List<String> strings = closestColor(List.of("000000001111111100000110"));
		strings.forEach(e -> System.out.println(e));
	}

	public static List<String> closestColor(List<String> pixels) {
		List<String> answer = new ArrayList<>();

		for (String input: pixels) {
			int R = Integer.parseInt(input.substring(0, 8), 2);
			int G = Integer.parseInt(input.substring(8, 16), 2);
			int B = Integer.parseInt(input.substring(16, 24), 2);

			String color = "Black";
			double blackVal = calculate(R, G, B, 0, 0, 0);
			double minVal = blackVal;

			double whiteVal = calculate(R, G, B, 255, 255, 255);
			if (minVal > whiteVal) {
				color = "White";
				minVal = whiteVal;
			}

			double redVal = calculate(R, G, B, 255, 0, 0);
			if (minVal > redVal) {
				color = "Red";
				minVal = redVal;
			}

			double greenVal = calculate(R, G, B, 0, 255, 0);
			if (minVal > greenVal) {
				color = "Green";
				minVal = greenVal;
			}

			double blueVal = calculate(R, G, B, 0, 0, 255);
			if (minVal > blueVal) {
				color = "Blue";
				minVal = blueVal;
			}

			int sameCount = 0; // 같은 값 개수 카운트
			if (minVal == blackVal) sameCount++;
			if (minVal == whiteVal) sameCount++;
			if (minVal == redVal) sameCount++;
			if (minVal == greenVal) sameCount++;
			if (minVal == blueVal) sameCount++;

			if (sameCount >= 2) {
				answer.add("Ambiguous");
			} else {
				answer.add(color);
			}

		}
		return answer;
	}

	private static double calculate(int R, int G, int B, int R2, int G2, int B2) {
		int a = R - R2;
		int b = G - G2;
		int c = B - B2;

		return Math.sqrt(a * a + b * b + c * c);
	}

}
