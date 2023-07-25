package programmers.kakao_blind_2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol2 {

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int deliver = 0;
		int pickup = 0;

		for (int i = n - 1; i >= 0; i--) {
			if (deliveries[i] > 0 || pickups[i] > 0) {
				int count = 0;
				while (deliver < deliveries[i] || pickup < pickups[i]) {
					// 인덱스 위치를 몇 번 방문할지 카운트
					count++;
					deliver += cap;
					pickup += cap;
				}

				deliver -= deliveries[i]; // 남은 트럭 자리 계산
				pickup -= pickups[i];
				answer += (i + 1) * count * 2;
			}
		}

		return answer;
	}

//	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
//		long answer = 0;
//		if(isAllZero(deliveries, pickups)) return 0;
//
//		int deliveryLastIndex = getDeliveryLastIndex(deliveries);
//		int pickupLastIndex = getDeliveryLastIndex(pickups);
//		answer += 2*(Math.max(deliveryLastIndex,pickupLastIndex)+1);
//
//		while(deliveryLastIndex >= 0 || pickupLastIndex >= 0) {
//			deliveryLastIndex = delivery(deliveries,cap,deliveryLastIndex);
//			pickupLastIndex = pickup(pickups,cap,pickupLastIndex);
//			answer += 2*(Math.max(deliveryLastIndex,pickupLastIndex)+1);                 }
//
//		return answer;
//	}
//
//	public int getDeliveryLastIndex(int[] deliveries){
//		for(int i = deliveries.length - 1; i >= 0; i--) {
//			if(deliveries[i] != 0) return i;
//		}
//		return 0;
//	}
//
//	public int getPickupLastIndex(int[] pickups){
//		for(int i = pickups.length - 1; i >= 0; i--) {
//			if(pickups[i] != 0) return i;
//		}
//		return 0;
//	}
//
//	public int delivery(int[] deliveries, int cap, int deliveryLastIndex) {
//		for(int i = deliveryLastIndex; i >= 0; i--) {
//			if(cap < 0) {
//				return i;
//			} else if(cap >= deliveries[i]) {
//				cap -= deliveries[i];
//				deliveries[i] = 0;
//			} else {
//				deliveries[i] -= cap;
//				return i;
//			}
//		}
//		return -1;
//	}
//
//	public int pickup(int[] pickups, int cap, int pickupLastIndex) {
//		for(int i = pickupLastIndex; i >= 0; i--) {
//			if(cap < 0){
//				return i;
//			} else if(cap >= pickups[i]) {
//				cap -= pickups[i];
//				pickups[i] = 0;
//			} else {
//				pickups[i] -= cap;
//				return i;
//			}
//		}
//		return -1;
//	}
//
//	public boolean isAllZero(int[] deliveries, int[] pickups) {
//		return isAllDeliveriesZero(deliveries) && isAllPickupsZero(pickups);
//	}
//
//	public boolean isAllDeliveriesZero(int[] deliveries) {
//		for(int i = 0; i < deliveries.length; i++) {
//			if(deliveries[i] != 0) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean isAllPickupsZero(int[] pickups) {
//		for(int i = 0; i < pickups.length; i++) {
//			if(pickups[i] != 0) {
//				return false;
//			}
//		}
//		return true;
//	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4,5,
				new int[]{1,0,3,1,2},
				new int[]{0,3,0,4,0}
		)).isEqualTo(
				16
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				2,7,
				new int[]{1,0,2,0,1,0,2},
				new int[]{0,2,0,1,0,2,0}
		)).isEqualTo(
				30
		);
	}


}

