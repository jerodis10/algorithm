package ex;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//import com.google.gson.*;
import java.net.*;
//import org.json.simple.*;
//import org.json.simple.parser.*;

public class ne3 {

	/*
	 * Complete the function below.
	 */
	static int getNumberOfMovies(String substr) throws IOException {
		String urlStr = "https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=" + substr;

		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}

			reader.close();

			// Parse JSON response
			String jsonResponse = response.toString();
			int totalIndex = jsonResponse.indexOf("\"total\":") + 8;
			int totalEndIndex = jsonResponse.indexOf(",", totalIndex);

			if (totalIndex != -1 && totalEndIndex != -1) {
				String totalStr = jsonResponse.substring(totalIndex, totalEndIndex);
				int total = Integer.parseInt(totalStr);

				return total;
			} else {
				System.out.println("Total not found in JSON response.");
			}

		}

		return 0;
	}

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;
		String _substr;
		try {
			_substr = in.nextLine();
		} catch (Exception e) {
			_substr = null;
		}

		res = getNumberOfMovies(_substr);
		bw.write(String.valueOf(res));
		bw.newLine();

		bw.close();
	}


}
