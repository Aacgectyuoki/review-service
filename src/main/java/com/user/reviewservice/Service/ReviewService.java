package com.user.reviewservice.Service;

import com.user.reviewservice.Model.Review;
import com.user.reviewservice.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review getReviewById(String ratingId) {
        return reviewRepository.findById(ratingId).orElse(null);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public void deleteReview(String ratingId) {
        reviewRepository.deleteById(ratingId);
    }

    public Review updateReview(String ratingId, Review updatedReview) {
        Review existingReview = getReviewById(ratingId);
        if (existingReview != null) {
            // Update the existing review with the data from the updatedReview
            existingReview.setUserId(updatedReview.getUserId());
            existingReview.setHotelId(updatedReview.getHotelId());
            existingReview.setRating(updatedReview.getRating());
            existingReview.setFeedback(updatedReview.getFeedback());
            // Save the updated review to the database
            return reviewRepository.save(existingReview);
        }
        return null; // Review with the provided ratingId does not exist
    }
}