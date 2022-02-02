package com.boot.bookingrestaurantapi.jsons;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantRest {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private Long name;
	
	@JsonProperty("address")
	private Long address;
	
	@JsonProperty("description")
	private Long description;
	
	@JsonProperty("image")
	private Long image;
	
	@JsonProperty("turn")
	private List<TurnRest> turns;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getName() {
		return name;
	}

	public void setName(Long name) {
		this.name = name;
	}

	public Long getAddress() {
		return address;
	}

	public void setAddress(Long address) {
		this.address = address;
	}

	public Long getDescription() {
		return description;
	}

	public void setDescription(Long description) {
		this.description = description;
	}

	public Long getImage() {
		return image;
	}

	public void setImage(Long image) {
		this.image = image;
	}

	public List<TurnRest> getTurns() {
		return turns;
	}

	public void setTurns(List<TurnRest> turns) {
		this.turns = turns;
	}
}
