import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class ex {
	
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
//		Assert.assertEquals(2, solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {0,0,1}}));
//		Assert.assertEquals(1, solution(new int[][] {{1,1,0}, {1,1,1}, {0,1,1}}));
//	}
	

}
