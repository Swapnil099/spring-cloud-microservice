package com.example.movieinfoservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSummary {

    private String id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Year")
    private String year;

    public MovieSummary(String id, String title, String plot, String year) {
        this.id = id;
        this.title = title;
        this.plot = plot;
        this.year = year;
    }

    public MovieSummary() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
