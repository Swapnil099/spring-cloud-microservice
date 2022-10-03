package com.example.moviecatalogservice.models;

import java.util.ArrayList;
import java.util.List;

 public class CatalogItem {
    String name;
    String desc;
    int rating;
  private static List<CatalogItem> users=new ArrayList<>();
  static {
	  users.add(new CatalogItem("Transformer","test",4));
  }
    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
