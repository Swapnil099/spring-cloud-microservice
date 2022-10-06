package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import com.example.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        System.out.println("its here");
        UserRating userRating = restTemplate.getForObject("http://movie-rating-service/ratingsdata/user/"+userId, UserRating.class);

        return userRating.getRatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
            return new CatalogItem(movie.getName(),"Desc",rating.getRating());
        }).collect(Collectors.toList());

    }
}

// Async request calls to APIs using webflux dependecies
// Movies movie = WebClientBuilder.build()
//         .get()
//         .url("http://localhost:8082/movies/"+rating.getMovieId())
//         .retrieve()
//         .bodyToMono(Movie.class)
//         .block() // block is making this call synchronous otherwise it will remain async

