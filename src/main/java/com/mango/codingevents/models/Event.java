package com.mango.codingevents.models;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity // makes class persistent
public class Event {

    @Id
    @GeneratedValue
    private int id;
//    we don't need nextId because database is going to generate id field.
//    private static int nextId = 1; //make static so all events share this id number

    @NotBlank(message="Please enter a name.") //prevents white spaces
    @Size(min=3, max=50, message="Name must be between 3 - 50 characters")
    private String name;

    @Size(max=500, message="Description too long.")
    private String description;

    @NotBlank(message="Please enter an email.")
    @Email(message="Invalid Email")
    private String contactEmail;

    private EventType type;

    @NotBlank(message="Please enter a location.")
    private String location;

    @NotBlank(message="How may attendees are coming?")
    @Size(min=1,message="Please enter how many people are coming.")
    private String attendees;

    public Event(String name, String description, String email, EventType type, String location, String attendees) {
//        this();
        this.name = name;
        this.description=description;
        this.contactEmail= email;
        this.type=type;
        this.location=location;
        this.attendees=attendees;
    }

    public Event(){ // no arg constructor to use for field binding
//        this.id=nextId;
//        nextId++;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
