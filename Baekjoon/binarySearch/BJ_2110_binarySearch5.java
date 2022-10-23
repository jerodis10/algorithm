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

        int N = Integer.parseInt(st.nextToken());  // ���� ����
        int C = Integer.parseInt(st.nextToken());  // �������� ����
        int[] homeList = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            homeList[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homeList);   // ����

        int left = 1;
        int right = homeList[N] - homeList[1];
        int d = 0;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int start = homeList[1];
            int count = 1;  // ������ ��ġ GAP ����
            for (int i = 1; i <= N; ++i) {
                d = homeList[i] - start;  // ������ �Ÿ� üũ
                if (d >= mid) {  // ������ ��ġ �������� ���� üũ
                    count++;
                    start = homeList[i]; // ��ġ �ߴٸ� ���� �� ���� �ٽ� �Ÿ� üũ
                }
            }

            if (count >= C) {
                ans = mid;
                left = mid + 1;  // �� ���� Gap���� ������ ��ġ�� �� �ִ��� ���� Ȯ��
            } else {
                right = mid - 1; // �� ���� Gap���� ������ ��ġ�� �� �ִ��� ���� Ȯ��
            }
        }

        System.out.println(ans);
    }
}
