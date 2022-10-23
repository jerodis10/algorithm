package Baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_binarySearch5 { 

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 집의 개수
        int C = Integer.parseInt(st.nextToken());  // 공유기의 개수
        int[] homeList = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            homeList[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homeList);   // 정렬

        int left = 1;
        int right = homeList[N] - homeList[1];
        int d = 0;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int start = homeList[1];
            int count = 1;  // 공유기 설치 GAP 저장
            for (int i = 1; i <= N; ++i) {
                d = homeList[i] - start;  // 집마다 거리 체크
                if (d >= mid) {  // 공유기 설치 가능한지 여부 체크
                    count++;
                    start = homeList[i]; // 설치 했다면 여기 집 부터 다시 거리 체크
                }
            }

            if (count >= C) {
                ans = mid;
                left = mid + 1;  // 더 많은 Gap에서 공유기 설치할 수 있는지 여부 확인
            } else {
                right = mid - 1; // 더 적은 Gap에서 공유기 설치할 수 있는지 여부 확인
            }
        }

        System.out.println(ans);
    }
}
