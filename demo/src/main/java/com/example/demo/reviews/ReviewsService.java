package com.example.demo.reviews;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewsService {

	@Autowired
	private ReviewsRepository reviewRepository;
		
	public List<Reviews> getAllCustomers(){
		List<Reviews> reviews = new ArrayList<Reviews>();
		for(Reviews c: reviewRepository.findAll()) {
			reviews.add(c);
		}
		return reviews;
	}
	
	public Reviews getReviewById(int id) {
		return reviewRepository.findOne(id);
	}
	
	
	public void addReview(Reviews c) {
		reviewRepository.save(c);
	}
	
	public void updateReview(int id, Reviews c) {
		reviewRepository.save(c);
	}
	
	public void deleteReview(int id) {
		reviewRepository.delete(id);
	}

}
