package com.mango.codingevents.data;

import com.mango.codingevents.models.Event;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    //need a place to put events
    private static final Map<Integer, Event> events = new HashMap<>(); // final hashmap can't change, but the data inside can

    //get all events
    public static Collection<Event> getAll(){ //Collection, return a list of events
        return events.values(); //.values() returns all values in list format
        //Collection is an interface and extends Iterable and allows us to loop over values
    }

    //get single event
    public static Event getById(int id){
        return events.get(id);
    }

    //add event
    public static void add(Event event){
        events.put(event.getId(), event);
    }

    //remove event
    public static void remove(int id){
        events.remove(id);
    }
}
