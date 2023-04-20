package com.mango.codingevents.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@Controller
@RequestMapping("events")
public class EventController {

    @RequestMapping()
    public String event(Model model){
        ArrayList<String> names = new ArrayList<>(Arrays.asList("denny","vlad","alexey"));
        model.addAttribute("names",names);
        return "events/index";
    }
}
