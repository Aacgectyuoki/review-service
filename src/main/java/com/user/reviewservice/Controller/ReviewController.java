package com.user.reviewservice.Controller;

import com.user.reviewservice.Model.Review;
import com.user.reviewservice.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(review));
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Review> getReview(@PathVariable String ratingId) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewById(ratingId));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Review> deleteReview(@PathVariable String ratingId) {
        reviewService.deleteReview(ratingId);
        return ResponseEntity.noContent().build();
    }
}
