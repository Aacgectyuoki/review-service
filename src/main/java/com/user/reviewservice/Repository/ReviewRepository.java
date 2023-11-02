package com.user.reviewservice.Repository;

import com.user.reviewservice.Model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
