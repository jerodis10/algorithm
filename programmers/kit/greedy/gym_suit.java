package programmers.kit.greedy;

import java.util.Arrays;

public class gym_suit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        boolean visited[] = new boolean[reserve.length];

        for(int i=0; i<lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = 0;
                    reserve[j] = 0;
                    break;
                }
            }
        }

        for(int i=0; i<lost.length; i++){
            if(lost[i] == 0) continue;
            for(int j=0; j<reserve.length; j++){
                if(reserve[j] == 0) continue;
                if(Math.abs(lost[i] - reserve[j]) > 1) continue;
                if(visited[j]) continue;

                visited[j] = true;
                answer++;
                break;
            }
        }
        return answer;
    }
}
