package com.example.mysite.Controller;

import com.example.mysite.Entity.Content;
import com.example.mysite.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentRepository repo;
    @GetMapping(value = "/{id}")
    public String contentshow(Model model,@PathVariable("id") int id){
        Content content=repo.findById(id).get(0);
        model.addAttribute("content",content);
        return "content.html";
    }
    @GetMapping(value = "/update/{id}")
    public String contentupdate(Model model){
        return "/";
    }
    @PostMapping(value = "/update/{id}")
    public String postcontentupdate(@RequestBody Model model){
        return "/";
    }
    @PostMapping(value = "/delete/{id}")
    public String deletecontent(){
        return "/";
    }
    @GetMapping(value = "/create")
    public String createcontent(){
        return "/";
    }
    @PostMapping(value = "/create")
    public String postcreatecontent(){
        return "/";
    }
}
