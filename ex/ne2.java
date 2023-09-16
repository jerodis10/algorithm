package ex;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.*;


public class ne2 {

	public static void main(String[] args) {
		List<Long> netProfit = getNetProfit(List.of("BUY googl 20", "BUY aapl 50", "CHANGE googl 6", "QUERY", "SELL aapl 10", "CHANGE aapl -2", "QUERY"));
		netProfit.forEach(e -> System.out.println(e));
	}

	public static List<Long> getNetProfit(List<String> events) {
		Map<String, Long> map = new HashMap<>();
		List<Long> answer = new ArrayList<>();
		long balance = 0;
		for (String eventStr : events) {
			String[] arr = eventStr.split(" ");
			if (arr[0].equals("BUY")) {
				map.put(arr[1], map.getOrDefault(arr[1], 0L) + Long.parseLong(arr[2]));
			}
			else if (arr[0].equals("CHANGE")) {
				balance = balance + Long.parseLong(arr[2]) * map.getOrDefault(arr[1], 0L);
			}
			else if (arr[0].equals("SELL")) {
				map.put(arr[1], map.get(arr[1]) - Long.parseLong(arr[2]));
			}
			else if (arr[0].equals("QUERY")) {
				answer.add(balance);
			}
		}
		return answer;
	}

}
