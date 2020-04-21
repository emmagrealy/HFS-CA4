package com.example.demo.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reviews {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String comment;
	private int rating;
	
	public Reviews() {
	
	}

	public Reviews(String comment, int rating) {
		this.comment = comment;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}