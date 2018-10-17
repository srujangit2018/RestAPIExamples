package com.epam.pojomappers;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Response1_POJO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "name", "owner", "cook", "waiter" })

	@JsonProperty("name")
	private String name;
	@JsonProperty("owner")
	private Owner owner;
	@JsonProperty("cook")
	private Cook cook;
	@JsonProperty("waiter")
	private Waiter waiter;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("owner")
	public Owner getOwner() {
		return owner;
	}

	@JsonProperty("owner")
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@JsonProperty("cook")
	public Cook getCook() {
		return cook;
	}

	@JsonProperty("cook")
	public void setCook(Cook cook) {
		this.cook = cook;
	}

	@JsonProperty("waiter")
	public Waiter getWaiter() {
		return waiter;
	}

	@JsonProperty("waiter")
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
