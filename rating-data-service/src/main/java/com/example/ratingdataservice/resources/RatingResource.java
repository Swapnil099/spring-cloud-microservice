package com.example.ratingdataservice.resources;

import com.example.ratingdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/movies/{movieId}")
    public Rating movieRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }
}
