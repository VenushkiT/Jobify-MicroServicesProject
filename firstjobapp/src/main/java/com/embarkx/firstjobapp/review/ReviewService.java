package com.embarkx.firstjobapp.review;

public interface ReviewService {
    <List> java.util.List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyID, Review review);

}
