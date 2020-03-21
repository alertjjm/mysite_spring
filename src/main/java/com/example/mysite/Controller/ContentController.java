package com.example.mysite.Controller;

import com.example.mysite.Entity.Content;
import com.example.mysite.Repository.ContentRepository;
import com.example.mysite.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentRepository repo;
    @Autowired
    ContentService serv;
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
        return "create.html";
    }
    @PostMapping(value = "/create")
    public String postcreatecontent( @RequestParam Map<String, String> body){
        Content result=serv.createContent(body.get("category"),body.get("title"),body.get("description"),body.get("longdescription"));//String category,String title,String description,String longdescription
        repo.save(result);
        String op=body.get("category");
        if (op.equals("award")){
            return "redirect:/awards";
        }
        else if(op.equals("license")){
            return "redirect:/licenses";
        }
        else if(op.equals("research")){
            return "redirect:/researches";
        }
        else if(op.equals("activities")){
            return "redirect:/activities";
        }
        else if(op.equals("stack")){
            return "redirect:/stacks";
        }
        return "redirect:/";
    }
}
