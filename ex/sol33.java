package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sol33 {

	public String[] solution(String[] teamIDs, String[] additional) {
		List<String> result = new ArrayList<>();
		Map<String, Boolean> map = new HashMap<>();

		for (String teamId : teamIDs) {
			map.put(teamId, true);
		}

		for (String addId : additional) {
			if (!map.containsKey(addId)) {
				map.put(addId, true);
				result.add(addId);
			}
		}

		return result.stream().toArray(String[]::new);
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[]{"world","prog"},
				new String[]{"hello","world","code","hello","try","code"}
		)).isEqualTo(
				new String[]{"hello","code","try"}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[]{"abc","hq","xyz"},
				new String[]{"hq","abc","pp","xy","pp","hq"}
		)).isEqualTo(
				new String[]{"pp","xy"}
		);
	}


}
