package programmers.kit.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class word_conversion {

	int result;
	boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		result = Integer.MAX_VALUE;
		visited = new boolean[words.length];

		bfs(begin, target, words);

		if(result == Integer.MAX_VALUE) return 0;

		return result;
	}

	public void bfs(String begin, String target, String[] words) {
		Queue<Word> q = new LinkedList<>();
		String cur = begin;
		Word word = new Word();
		word.setWord(cur);
		word.setCount(0);
		q.add(word);

		while(!q.isEmpty()) {
			word = q.poll();

			if(word.getWord().equals(target)) {
				result = Math.min(result, word.getCount());
				return;
			}


			for(int i=0; i<words.length; i++) {
				if(!visited[i] && check(word.getWord(), words[i])) {
					visited[i] = true;
					Word next = new Word();
					next.setWord(words[i]);
					next.setCount(word.getCount()+1);
					q.add(next);
				}
			}
		}
	}

	public class Word {
		private String word;
		private int count;
		public String getWord() {
			return word;
		}
		public void setWord(String word) {
			this.word = word;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}

	}

	public void dfs(String begin, String target, String[] words, int depth){
		if(begin.equals(target)) {
			result = Math.min(result, depth);
			return;
		}

		for(int i=0; i<words.length; i++) {
			if(!visited[i] && check(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, depth + 1);
				visited[i] = false;
			}
		}
	}

	public boolean check(String begin, String target) {
		int count = 0;

		for(int i=0; i<begin.length(); i++) {
			if(begin.charAt(i) == target.charAt(i)) {
				count++;
			}
		}

		if(count == begin.length() - 1) {
			return true;
		}
		return false;
	}
	
	
//	@Test
//	public void testCase() {
//		Assert.assertEquals(4, solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
//		Assert.assertEquals(0, solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
//	}
	
}
