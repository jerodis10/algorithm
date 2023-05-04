package programmers.kit.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class largest_number {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] a = {1, 5, 2, 6, 3, 7, 4};
		int[][] b = {{2,5,3},{4,4,1},{1,7,3}};
		
//		int[] a = {95, 90, 99, 99, 80, 99};
//		int[] b = {1, 1, 1, 1, 1, 1};
		
//		int[] re = solution(a, b);
//		
//		for(int i=0;i<re.length;i++)
//			System.out.println(re[i]);
	}
	

	public String solution(int[] numbers) {
		String answer = "";
        //문자열 리턴을 해줄 스트링배열 생성
        String[] str = new String[numbers.length];
        
        //int배열 String배열로 변환
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }     
        
        //내림차순 정렬
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
                //오름차순 정렬 (o1+o2).compareTo(o1+o2);
            }
        });
        
        //0값이 중복일경우 ex.ex){0,0,0}
        //답이 000이 나오면 안되므로 첫번째값이 0이면 0을 리턴
        if (str[0].equals("0")) return "0";
        
        //0이 아니면 문자열을 더해준다.
        for(String s: str) answer += s;
 
        return answer;
	}
}
