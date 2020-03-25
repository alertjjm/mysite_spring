package com.example.mysite.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BasicController {
    @GetMapping("/")
    public String welcome(){
        return "index.html";
    }
    @GetMapping("/about")
    public String about(){return "about.html";}
    @GetMapping("/contact")
    public String contact(){return "contact.html";}

}
