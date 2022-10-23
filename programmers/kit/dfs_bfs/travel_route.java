package programmers.kit.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class travel_route {
	
	boolean[] visited;
	List<String> path;
	
	public String[] solution(String[][] tickets) {
		String[] answer = {};
		visited = new boolean[tickets.length];
		path = new ArrayList<>();
		
		dfs("ICN", "ICN", tickets, 0);
		
		Collections.sort(path);
		answer = path.get(0).split(" ");
		
		return answer;
		
	}
	
	public void dfs(String start, String route, String[][] tickets, int depth){
		if(depth == tickets.length) {
			path.add(route);
			return;
		}
		
		for(int i=0; i<tickets.length; i++) {
			if(start.equals(tickets[i][0]) && !visited[i]) {
				visited[i] = true;
				dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	
	@Test
	public void testCase() {
		Assert.assertEquals(new String[] {"ICN", "JFK", "HND", "IAD"}, solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
		Assert.assertEquals(new String[] {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}, solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));
		
	}
	
}
