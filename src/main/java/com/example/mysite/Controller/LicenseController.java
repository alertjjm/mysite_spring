package com.example.mysite.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LicenseController {
    @GetMapping("/licenses")
    public String licenses(){
        return "licenses.html";
    }
}
