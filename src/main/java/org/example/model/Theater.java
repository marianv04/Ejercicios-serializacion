package org.example.model;

import java.io.Serializable;

public class Theater implements Serializable {
    private String name;
    private int capacity;

    public Theater(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName(){
        return "The name of the theater is" + name + "and has a capacity of" + capacity + "people.";
    }

}

