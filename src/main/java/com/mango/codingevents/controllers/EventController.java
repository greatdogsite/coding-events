package com.mango.codingevents.controllers;


import com.mango.codingevents.data.EventData;
import com.mango.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("events")
public class EventController {

    //@GetMapping("index")
    @GetMapping()
    public String displayAllEvents(Model model){
        model.addAttribute("events", EventData.getAll()); //for accessing Class Methods
        return "events/index";
    }

    // lives at events/create
    @RequestMapping("create") //default is GET
    public String renderCreateEventForm(){
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
    public String processCreateEventForm(@ModelAttribute Event newEvent){
        EventData.add(newEvent); //add to private static arraylist
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDelete(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    // since checkbox form collected all eventIds under the same name, they will be submitted as a collection
    public String processDelete(@RequestParam(required = false) int[] eventIds){
        if (eventIds != null){
            for (int id : eventIds){
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{id}")
    public String displayEditForm(Model model,
                                  @PathVariable int id){
        Event event = EventData.getById(id);
        model.addAttribute(event);
        model.addAttribute("title","Edit Event " + event.getName() +" (id=" + event.getId() + ")");
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description){
        Event event = EventData.getById(eventId);
        event.setName(name);
        event.setDescription(description);
        return "redirect:";
    }

}
