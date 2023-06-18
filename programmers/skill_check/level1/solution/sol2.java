package programmers.skill_check.level1.solution;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class sol2 {

	public double solution(int[] arr) {
		double answer = 0;

		double sum = 0;
		for(int num : arr) {
			sum += num;
		}

		return sum / arr.length;
	}

}
