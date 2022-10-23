package programmers.level.level2;

import java.util.Arrays;
import java.util.Comparator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sort_file_names {
	
	public String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] file1 = getStrPart(o1);
				String[] file2 = getStrPart(o2);
				
				int headValue = file1[0].compareTo(file2[0]);
				
				if(headValue == 0) {
					int num1 = Integer.parseInt(file1[1]);
					int num2 = Integer.parseInt(file2[1]);
					
					return num1 - num2;
				} else {
					return headValue;
				}
			}
			
		});
		
		return files;
   }
	
	public String[] getStrPart(String str) {
		String head = "";
		String number = "";
		String tail = "";

		int idx = 0;
		for( ; idx < str.length() ; ++idx) {
			char ch = str.charAt(idx);
			if(ch >= '0' && ch <= '9') break;
			head += ch;
		}
		
		for( ; idx < str.length() ; ++idx) {
			char ch = str.charAt(idx);
			if(!(ch >= '0' && ch <= '9')) break;
			number += ch;
		}
		
		for( ; idx < str.length() ; ++idx) {
			char ch = str.charAt(idx);
			tail += ch;
		}
		
		String[] file = {head.toLowerCase(), number, tail};
		
		return file;
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}
		)).isEqualTo(
				new String[] {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14Tomcat"}
		)).isEqualTo(
				new String[] {"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14Tomcat"}
		);
	}
	
}
