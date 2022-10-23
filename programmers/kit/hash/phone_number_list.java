package programmers.kit.hash;

import java.util.HashMap;
import java.util.Map;

public class phone_number_list {
	public boolean solution(String[] phone_book) {
		// 1. HashMap을 선언한다. 
		Map<String, Integer> map = new HashMap<>(); 
		
		// 2. 모든 전화번호를 HashMap에 넣는다.
		for (int i = 0; i < phone_book.length; i++) 
			map.put(phone_book[i], i); 
		
		// 3. 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다. 
		for (int i = 0; i < phone_book.length; i++) 
			for (int j = 0; j < phone_book[i].length(); j++) 
				if (map.containsKey(phone_book[i].substring(0, j))) 
					return false; return true;


	}
	
//	public static void main(String[] args){ 
//		String[] phone_book = {"119", "1183", "11832"}; 
//		pg_hash2 sol = new pg_hash2(); 
//		System.out.println(sol.solution(phone_book)); 
//	}

}
