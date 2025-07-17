package target2024.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * {
 *     "page": 1,
 *     "per_page": 10,
 *     "total": 2,
 *     "total_pages": 1,
 *     "data": [
 *         {
 *             "name": "British Indian Ocean Territory",
 *             "population": 3000,
 *             "demonym": "Indian"
 *         }
 *     ]
 * }
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
	private int page;
	@JsonProperty("per_page")
	private int perPage;
	private int total;
	@JsonProperty("total_pages")
	private int totalPages;
	private List<Country> data;

	// Getters and setters
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<Country> getData() {
		return data;
	}

	public void setData(List<Country> data) {
		this.data = data;
	}
}

