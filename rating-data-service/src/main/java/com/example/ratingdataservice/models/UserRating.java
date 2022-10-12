package com.example.ratingdataservice.models;

import java.util.List;

public class UserRating {
    private List<Rating> ratings;
    private String userId;


    public UserRating(List<Rating> ratings, String userId) {
        this.ratings = ratings;
        this.userId = userId;
    }


    public UserRating() {
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

