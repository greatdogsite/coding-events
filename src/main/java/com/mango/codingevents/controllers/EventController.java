package com.mango.codingevents.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> names = new ArrayList<>();

    //@GetMapping("index")
    @GetMapping()
    public String displayAllEvents(Model model){
        model.addAttribute("names",names);
        return "events/index";
    }

    // lives at events/create
    @RequestMapping("create") //default is GET
    public String renderCreateEventForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName){
        names.add(eventName); //add to private static arraylist
//        return "redirect:index"; //redirect is 300 level http redirect to events/index
        return "redirect:";
    }
}
