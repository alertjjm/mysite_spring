package com.example.mysite.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SStackController {
    @GetMapping("/stack")
    public String stack(){
        return "sstack.html";
    }

}
