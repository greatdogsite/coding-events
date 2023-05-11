package com.mango.codingevents.data;

import com.mango.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> { //stores Event type with Integer as PRIMARY KEY
}
