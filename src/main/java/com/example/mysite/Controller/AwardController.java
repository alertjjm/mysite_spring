package com.example.mysite.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AwardController {
    @GetMapping("/awards")
    public String awards(){
        return "awards.html";
    }
}
