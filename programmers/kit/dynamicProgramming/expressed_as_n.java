package programmers.kit.dynamicProgramming;

public class expressed_as_n {
	
	static final int MAX = 32_000;
	
	int minN;
	
	public int solution(int N, int number) {
		minN = Integer.MAX_VALUE;

		dfs(0, N, number, 0);

		return (minN != Integer.MAX_VALUE) ? minN : -1 ;
	}


	public void dfs(int cur, int n, int number, int depth) {
		if(depth > 8) return;
		if(cur == number) {
			minN = Math.min(minN, depth);
			return;
		}

		int num = 0;
		int index = 0;
		while(num <= MAX) {
			num = num * 10 + n;
			 
			dfs(cur + num, n, number, depth + index + 1);
			dfs(cur - num, n, number, depth + index + 1);
			dfs(cur * num, n, number, depth + index + 1);
			dfs(cur / num, n, number, depth + index + 1);
			
			index++;
		}
	}
}
