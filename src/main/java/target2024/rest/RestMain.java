package target2024.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//https://jsonmock.hackerrank.com/api/countries/search?name=
//Return a response of countries with a population over 1000000 and searchName as substring
public class RestMain {
	public static void main(String[] args) {
		try {
			int result = countFromResponse("india", 6000);
			System.out.println(result);
		} catch (Exception ex) {
			System.out.println("Exception = " + ex.getMessage());
		}
	}

	public static int countFromResponse(String str, Integer population) throws Exception {
		URL url = new URL("https://jsonmock.hackerrank.com/api/countries/search?name=" + str);

		// Open a connection to the URL
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		// Set the request method to GET
		conn.setRequestMethod("GET");

		// Set the request headers
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");

		// Check the response code
		int responseCode = conn.getResponseCode();
		System.out.println("Response Code: " + responseCode);

		// Read the response data
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// Print the response data
		System.out.println(response);

		//Method 1
		ObjectMapper objectMapper = new ObjectMapper();
		ApiResponse parsedResponse = objectMapper.readValue(response.toString(), ApiResponse.class);
		System.out.println("Page: " + parsedResponse.getPage());
		System.out.println("Total: " + parsedResponse.getTotal());
		for (Country country : parsedResponse.getData()) {
			System.out.println("Country Name: " + country.getName());
			System.out.println("Population: " + country.getPopulation());
			System.out.println("Demonym: " + country.getDemonym());
		}

		//Method 2
		JSONObject jsonObj = new JSONObject(response.toString());
		JSONArray dataArray = jsonObj.getJSONArray("data");

		// Calculate total based on population > 1,000,000
		int total = 0;
		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject country = dataArray.getJSONObject(i);
			int resPopulation = country.getInt("population");
			if (resPopulation > population) {
				total++;
			}
		}

		return total;
	}
}
