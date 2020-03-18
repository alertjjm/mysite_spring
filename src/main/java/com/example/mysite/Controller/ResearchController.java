package com.example.mysite.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResearchController {
    @GetMapping("/researches")
    public String researches(){
        return "researches.html";
    }
}
