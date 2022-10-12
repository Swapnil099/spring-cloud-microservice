package com.example.moviecatalogservice.services;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
        return new CatalogItem(movie.getName(),"Desc",rating.getRating());
    }

    public CatalogItem getFallbackCatalog(Rating rating) {
        return new CatalogItem("Movie Name Not Found","",rating.getRating());
    }
}
