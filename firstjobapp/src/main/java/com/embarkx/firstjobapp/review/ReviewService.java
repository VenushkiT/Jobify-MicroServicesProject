package com.embarkx.firstjobapp.review;

public interface ReviewService {
    <List> java.util.List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    boolean updateReview(Long companyId, Long reviewId, Review review);


    Review getReview(Long companyId, Long reviewId);
    boolean deleteReview(Long companyId, Long reviewId);
}
