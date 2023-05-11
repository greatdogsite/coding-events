package com.mango.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class EventCategory {

    @Id
    @GeneratedValue
    private int id;

    @Size(min=3, message="Name must be at least 3 characters")
    private String name;

    public EventCategory(String name) {
        this.name = name;
    }

    public EventCategory(){ //empty constructor for model binding

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
