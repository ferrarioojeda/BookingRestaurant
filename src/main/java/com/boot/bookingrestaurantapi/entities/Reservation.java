package com.boot.bookingrestaurantapi.entities;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "RESERVATION")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable= false)
	private Long id;
	
	@Column(name = "LOCATOR")
	private String locator;
	
	@Column(name = "TURN")
	private String turn;
	
	public String getTunr() {
		return turn;
	}

	public void setTunr(String turn) {
		this.turn = turn;
	}

	@Column(name = "PERSON")
	private Long person;
	
	@Column(name = "DATE")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTAURANT_ID", nullable = false)
	private Restaurant restaurant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public Long getPerson() {
		return person;
	}

	public void setPerson(Long person) {
		this.person = person;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
