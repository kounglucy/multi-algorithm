package com.spring.mongodb.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "rating")
public class Rating {
	
	@MongoId
	private Double id;
	
	private Double rating;
	
	@Field(name = "user_id")
	private Double userId;
	
	public Double getId() {
		return id;
	}
	public void setId(Double id) {
		this.id = id;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Double getUserId() {
		return userId;
	}
	public void setUserId(Double userId) {
		this.userId = userId;
	}
	
	public Rating() {}
	public Rating(Double id, Double rating, Double userId) {
		super();
		this.id = id;
		this.rating = rating;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", userId=" + userId + "]";
	}
	
}