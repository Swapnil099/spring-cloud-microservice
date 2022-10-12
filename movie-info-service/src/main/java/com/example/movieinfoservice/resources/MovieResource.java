package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    Map<String,String> imdbId = new HashMap<>();
    @Autowired
    RestTemplate restTemplate;

    @Value("${api.key}")
    String apiKey;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) throws JsonProcessingException {

        if(imdbId.size() == 0){
            for(Integer i=1;i<=100;i++){
                Double idInDouble = Math.floor((Math.random() * 2155529) + 1);
                Integer id = idInDouble.intValue();
                while(id < 1000000) id*=10;
//            System.out.println(i + " -> " + id);
                imdbId.put(i.toString(),id.toString());
            }
        }

        String apiResponse = restTemplate.getForObject("https://www.omdbapi.com/?i=tt" + imdbId.get(movieId) + "&apikey="+apiKey, String.class);
        System.out.println(apiResponse);
        JsonObject jsonObject = new JsonParser().parse(apiResponse).getAsJsonObject();

        if(jsonObject.get("Title") == null){
            System.out.println("-><- null found -><-");
            apiResponse = restTemplate.getForObject("https://www.omdbapi.com/?i=tt" + 1501099 + "&apikey="+apiKey, String.class);
            jsonObject = new JsonParser().parse(apiResponse).getAsJsonObject();
            movieId = "1501099";
        }

        System.out.println(jsonObject);

        return new Movie(
                movieId
                ,jsonObject.get("Title").getAsString()
                ,jsonObject.get("Plot").getAsString()
                ,jsonObject.get("Year").getAsString());
    }
}
