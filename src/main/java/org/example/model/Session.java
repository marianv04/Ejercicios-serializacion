package org.example.model;

import java.io.Serializable;

public class Session implements Serializable {
    private Movie movie;
    private Theater theater;
    private Theater capacity;

    public Session(Movie movie, Theater theater) {
        this.movie = movie;
        this.theater = theater;
        this.capacity = capacity;
    }

    public String session(){
        return "The session is" + movie.getTitle() + "in the theater" + theater.getName() + "with a capacity of" + capacity + "people." ;
    }
}

