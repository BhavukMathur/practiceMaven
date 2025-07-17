package target2024.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
	private String name;
	private int population;
	private String demonym;

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getDemonym() {
		return demonym;
	}

	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}
}
