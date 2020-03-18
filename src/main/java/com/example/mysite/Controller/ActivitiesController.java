package com.example.mysite.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActivitiesController {
    @GetMapping("/activities")
    public String activities(){
        return "activities.html";
    }
}
