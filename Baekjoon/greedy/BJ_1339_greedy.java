package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1339_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strArr = new String[n];
		for (int i = 0; i < n; i++) {
			strArr[i] = br.readLine();
		}

		System.out.println(solution(n, strArr));
	}

	public static int solution(int n, String[] strArr) {
		int sum = 0;
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> strPos = new HashMap<>();
		boolean[] visited = new boolean[10];

		for (String str : strArr) {
			strPos.put(str, 0);
		}
		int count = 0;
		while(count < n) {
			String str = null;
			int curPos = -1;
			int len = -1;
			for (String key : strPos.keySet()) {
				if (key.substring(strPos.get(key)).length() > len) {
					curPos = strPos.get(key);
					str = key;
					len = key.substring(strPos.get(key)).length();
				}
			}
			if (str.length() == curPos) {
				count++;
				continue;
			}

			String s1 = str.substring(curPos, curPos + 1);
			if (!map.containsKey(s1)) {
				for (int i = 9; i >= 0; i--) {
					if (!visited[i]) {
						map.put(s1, i);
						visited[i] = true;
						sum += i * Math.pow(10, str.length() - curPos - 1);
						strPos.put(str, curPos + 1);
						break;
					}
				}
			} else {
				sum += map.get(s1) * Math.pow(10, str.length() - curPos - 1);
				strPos.put(str, curPos + 1);
			}
		}

		return sum;
	}
	
}
