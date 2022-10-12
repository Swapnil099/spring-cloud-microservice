package com.example.ratingdataservice.resources;

import com.example.ratingdataservice.models.Rating;
import com.example.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating movieRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getRating(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("99",4),
                new Rating("100",5)
        );
        UserRating userRating = new UserRating(ratings,userId);
        return userRating;
    }
}
