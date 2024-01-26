package com.chaorda.matchuum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/test")
    public String view(){
        return "receive";
    }
}
