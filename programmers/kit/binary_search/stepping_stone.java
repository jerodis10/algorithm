package programmers.kit.binary_search;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class stepping_stone {
	
	public int solution(int distance, int[] rocks, int n) {
        long ans = 0;
        long left = 1, right = distance, mid = 0;
        
        // 이분탐색은 오름차순으로 정렬되어있는 경우를 전제로한다.
        Arrays.sort(rocks);
    
        while(left <= right){
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2; 
            
            for(int i = 0 ; i < rocks.length ; ++i){
                if(rocks[i] - prev < mid){
                	// mid보다 작은 값이 존재한다는 뜻으로
                    // 해당 돌을 제거한다.
                    cnt++;
                } else {
           			// mid보다 크거나 같은 값이 존재하므로
                    // prev를 현재 돌로 초기화한다.
                    prev = rocks[i];
                }
            }
            
            // 마지막 돌과 도착점 사이의 거리도 확인한다.
            if(distance - prev < mid) cnt++;
            
            if(cnt <= n){
            	// 주어진 n 보다 작거나 같은 만큼 돌을 없애서
                // 최솟값 x를 만들 수 있다.
                ans = mid > ans ? mid : ans;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
	}
	
	@Test
	public void testCase() {
		Assert.assertEquals(4, solution(25, new int[] {2, 14, 11, 21, 17}, 2));
	}
}
