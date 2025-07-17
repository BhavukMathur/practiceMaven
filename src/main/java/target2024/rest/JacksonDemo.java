package target2024.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo {
	public static void main(String[] args) {
		String json = "{\"page\":1,\"per_page\":10,\"total\":2,\"total_pages\":1,\"data\":[{\"name\":\"British Indian Ocean Territory\",\"population\":3000,\"demonym\":\"Indian\"}]}";

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ApiResponse response = objectMapper.readValue(json, ApiResponse.class);
			System.out.println("Page: " + response.getPage());
			System.out.println("Total: " + response.getTotal());
			for (Country country : response.getData()) {
				System.out.println("Country Name: " + country.getName());
				System.out.println("Population: " + country.getPopulation());
				System.out.println("Demonym: " + country.getDemonym());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
