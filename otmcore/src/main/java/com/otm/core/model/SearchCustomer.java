package com.otm.core.model;

public class SearchCustomer {
	// https://www.baeldung.com/rest-search-language-spring-jpa-criteria
	private String key;
	private String operation;
	private Object value;

	public SearchCustomer(String key, String operation, Object value) {
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	/*
	 * @Test public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect()
	 * { List<SearchCriteria> params = new ArrayList<SearchCriteria>();
	 * params.add(new SearchCriteria("firstName", ":", "John")); params.add(new
	 * SearchCriteria("lastName", ":", "Doe"));
	 * 
	 * List<User> results = userApi.searchUser(params);
	 * 
	 * assertThat(userJohn, isIn(results)); assertThat(userTom, not(isIn(results)));
	 * }
	 */
}