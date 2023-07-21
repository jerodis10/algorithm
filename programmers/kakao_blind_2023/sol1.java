package programmers.kakao_blind_2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class sol1 {

	String todayFormatted;
	int to;
	String[][] termList;
	String[][] privacieList;
	List<Integer> resultList;

	public int[] solution(String today, String[] terms, String[] privacies) {
		todayFormatted = today.replace(".", "");
		to = Integer.parseInt(todayFormatted);

		termList = new String[terms.length][2];
		for (int i = 0; i < terms.length; i++) {
			termList[i] = terms[i].split(" ");
		}

		privacieList = new String[privacies.length][4];
		for (int i = 0; i < privacies.length; i++) {
			String s = privacies[i].replace(".", " ");
			privacieList[i] = s.split(" ");
		}

		for (int i = 0; i < privacieList.length; i++) {
			String privacie = "";
			for (int j = 0; j < termList.length; j++) {
				if (privacieList[i][3].equals(termList[j][0])) {
					int yy = Integer.parseInt(privacieList[i][0]);
					int mm = Integer.parseInt(privacieList[i][1]) + Integer.parseInt(termList[j][1]);

					if (mm > 12) {
						yy += mm / 12;
						mm = mm % 12;
					}

					privacie += yy;

					if(mm < 10) privacie += "0" + mm;
					else privacie += mm;

					if(Integer.parseInt(privacieList[i][2]) < 11) privacie += "0" + Integer.valueOf(Integer.parseInt(privacieList[i][2]) - 1);
					else privacie += Integer.valueOf(Integer.parseInt(privacieList[i][2]) - 1);
				}
			}

			if (to > Integer.parseInt(privacie)) {
				resultList.add(i + 1);
			}
		}

		Collections.sort(resultList);
		int[] result = resultList.stream().mapToInt(i -> i).toArray();

		return result;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"2022.05.19",
				new String[]{"A 6", "B 12", "C 3"},
				new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}
		)).isEqualTo(
				new int[]{1,3}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"2020.01.01",
				new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"},
				new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}
		)).isEqualTo(
				new int[]{1,4,5}
		);
	}


}
