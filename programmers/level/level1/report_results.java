package programmers.level.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class report_results {

	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        
        Map<String, HashSet<String>> reportedMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
			HashSet<String> reportingId = new HashSet<>(); 
			reportedMap.put(id_list[i], reportingId); 
			answerMap.put(id_list[i], 0);  
		}
        
        for(String s : report) {
        	String[] reportStr = s.split(" ");
        	String reportingId = reportStr[0];
        	String reportedId = reportStr[1];
        	reportedMap.get(reportedId).add(reportingId);
        }
        
        for(String reportedUser : reportedMap.keySet()) {
        	HashSet<String> userForSend = reportedMap.get(reportedUser);
        	if (userForSend.size() >= k) {
        		for (String userId : userForSend) {
					answerMap.put(userId, answerMap.get(userId) + 1); 
				}
        	}
        }
        
        for (int i = 0; i < id_list.length; i++) {
			answer[i] = answerMap.get(id_list[i]);
		}
        
        return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[]{"muzi", "frodo", "apeach", "neo"}, 
				new String[]{"muzi frodo","apeach frodo","frodo neo", "muzi neo","apeach muzi"}, 
				2
		)).isEqualTo(new int[] {2,1,1,0});
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[]{"con", "ryan"}, 
				new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 
				3
		)).isEqualTo(new int[] {0,0});
	}
	
}
