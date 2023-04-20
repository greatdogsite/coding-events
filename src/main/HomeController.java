package com.mango.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping("index") //default is GET
    public String index(){

        return "index";
    }

}
