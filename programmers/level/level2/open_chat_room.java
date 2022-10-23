package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class open_chat_room {

	public String[] solution(String[] record) {
		List<String> list = new ArrayList<>();
		Map<String, String> idMap = new HashMap<>();

		for (String rec : record) {
			String[] recArr = rec.split(" ");
			if (!recArr[0].equals("Leave")) {
				idMap.put(recArr[1], recArr[2]);
			}
		}

		for (String rec : record) {
			String[] recArr = rec.split(" ");
			if (recArr[0].equals("Enter")) {
				list.add(idMap.get(recArr[1]) + "님이 들어왔습니다.");
			} else if (recArr[0].equals("Leave")) {
				list.add(idMap.get(recArr[1]) + "님이 나갔습니다.");
			}
		}

		return list.stream().toArray(String[]::new);
	}
	

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}
		)).isEqualTo(
				new String[] {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}
		);
	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				1,
//				new int[] {1,0,0,0,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {-1}
//		);
//	}
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				9,
//				new int[] {0,0,1,2,0,1,1,1,1,1,1}
//		)).isEqualTo(
//				new int[] {1,1,2,0,1,2,2,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				10,
//				new int[] {0,0,0,0,0,0,0,0,3,4,3}
//		)).isEqualTo(
//				new int[] {1,1,1,1,1,1,1,1,0,0,2}
//		);
//	}
}
