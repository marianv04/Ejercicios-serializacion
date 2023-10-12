package org.example.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    public Movie(String title) {
        this.title = title;
    }
    public String getTitle(){
        return "The title is:" + title;
    }
}
