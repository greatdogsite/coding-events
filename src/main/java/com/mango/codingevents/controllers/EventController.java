package com.mango.codingevents.controllers;


import com.mango.codingevents.data.EventRepository;
import com.mango.codingevents.models.Event;
import com.mango.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    //findAll, save, findById

    //@GetMapping("index")
    @GetMapping()
    public String displayAllEvents(Model model){
        model.addAttribute("events", eventRepository.findAll()); //for accessing Class Methods
        return "events/index";
    }

    // lives at events/create
    @GetMapping("create") //default is GET
    public String renderCreateEventForm(Model model){
        model.addAttribute("title", "Create an Event");
        model.addAttribute(new Event());
        model.addAttribute("types",EventType.values()); //returns array of values of type
        return "events/create";
    }

//    @PostMapping("create")
//    public String processCreateEventForm(@RequestParam String eventName,
//                                         @RequestParam String eventDescription){
//        EventData.add(new Event(eventName, eventDescription)); //add to private static arraylist
////        return "redirect:index"; //redirect is 300 level http redirect to events/index
//        return "redirect:";
//    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Create an Event");
            return "events/create";
        }
        eventRepository.save(newEvent); //add to private static arraylist
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDelete(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    // since checkbox form collected all eventIds under the same name, they will be submitted as a collection
    public String processDelete(@RequestParam(required = false) int[] eventIds){
        if (eventIds != null){
            for (int id : eventIds){
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}
