package programmers.kit.stack_queue;

import java.io.IOException;
import java.util.Stack;

public class stock_price {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int a = 2;
//		int[] b = {7,4,5,6};
//		int c = 8;
		
		int[] a = {1, 2, 3, 2, 3};
//		int[] b = {10};
//		int c = 100;
		
		int[] ret = solution(a);
		
		System.out.println(ret);
	}
	

	public static int[] solution(int[] prices) {
		
		int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();  // 답을 구했기 때문에 stack에서 제거
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
	}
}
