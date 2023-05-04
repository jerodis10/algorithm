package programmers.kit.greedy;

import java.io.IOException;

public class joystick {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		String n = "JAZ";
		String n = "BCDAAXYZEAAAFG";
		
		System.out.println(solution(n));
	}
	
	public static int solution(String name) {
		int answer = 0;
		int len = name.length();
		
		/*
		 * 커서 위치가 바뀌게 되는 경우는 총 세 가지이다. 1. 처음부터 쭉 오른쪽으로 가는 경우 가장 일반적인 경우로 name.length() -
		 * 1로 해당한다. 2. 오른쪽으로 갔다 다시 리턴하여 왼쪽으로 가는 경우 ex.ex) BBAAAAAYYY 의 경우, BB까지 갔다가 다시 돌아가
		 * YYY를 완성해준다. 3. 왼쪽으로 갔다 다시 리턴하여 오른쪽으로 가는 경우 ex.ex) CCCAAAAAAY 의 경우, 처음부터 왼쪽으로 움직여
		 * Y를 완성해주고 다시 오른쪽으로 돌아가 CCC를 완성해준다.
		 */
	
		// 제일 짧은 좌, 우 이동은 그냥 맨 오른쪽으로 이동할 때
		int min = len - 1;
	
		for (int i = 0; i < len; i++) {
		  // 조이스틱 상, 하 이동
		  char c = name.charAt(i);
		  int mov = (c - 'A' < 'Z' - c + 1) ? (c - 'A') : ('Z' - c + 1);
		  answer += mov;
	
		  // 조이스틱 좌, 우 이동
		  int nextIndex = i + 1;
		  // 다음 단어가 A이고, 단어가 끝나기 전까지 nextIndex 증가
		  while (nextIndex < len && name.charAt(nextIndex) == 'A')
			  nextIndex++;
	
//		  min = Math.min(min, (i * 2) + len - nextIndex);
		  min = Math.min(min, i+len-nextIndex+Math.min(i,len-nextIndex));
		}
	
		answer += min;
	
		return answer;
	}
}
