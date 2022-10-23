package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class dart_game {

	public int solution(String dartResult) {
        int[] round = new int[3];
        char[] carr = dartResult.toCharArray();
        int idx = -1;
        for (int i=0;i<carr.length;i++) {
            if (carr[i] >= '0' && carr[i] <= '9') {
                idx++; 
                round[idx] += Integer.parseInt(String.valueOf(carr[i]));
                if (i+1!=carr.length-1 && carr[i+1] == '0'&& carr[i] == '1') {
                    round[idx] -= Integer.parseInt(String.valueOf(carr[i]));
                    round[idx] = 10;
                    i++;                    
                }                
            } else if (carr[i] == 'D') { 
                round[idx] *= round[idx]; 
            } else if(carr[i] == 'T') { 
                round[idx] *= round[idx] * round[idx];
            } else if (carr[i] == '*') { 
                if (idx > 0) round[idx-1] *=2;                
                round[idx] *= 2;
            } else if (carr[i] == '#') {             
                round[idx] *= -1;
            }
        }
        
        return round[0] + round[1] + round[2];
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"1S2D*3T"
		)).isEqualTo(37);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"1D2S#10S"
		)).isEqualTo(9);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"1D2S0T"
		)).isEqualTo(3);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"1S*2T*3S"
				)).isEqualTo(23);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				"1D#2S*3S"
				)).isEqualTo(5);
	}
	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				"1T2D3D#"
				)).isEqualTo(-4);
	}
	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				"1D2S3T*"
				)).isEqualTo(59);
	}
	
}
