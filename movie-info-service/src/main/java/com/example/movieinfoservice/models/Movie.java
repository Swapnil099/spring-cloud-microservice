package com.example.movieinfoservice.models;

public class Movie {
    String movieId;
    String name;
    String plot;
    String year;


    public Movie(String movieId, String name, String plot, String year) {
        this.movieId = movieId;
        this.name = name;
        this.plot = plot;
        this.year = year;
    }

    public Movie() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
