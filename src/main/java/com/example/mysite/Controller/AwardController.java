package com.example.mysite.Controller;

import com.example.mysite.Entity.Content;
import com.example.mysite.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AwardController {
    @Autowired
    ContentRepository repo;

    @GetMapping("/awards")
    public String awards(Model model){
        List<Content> contentList=repo.findAllByCategory("award");
        model.addAttribute("contentList",contentList);
        model.addAttribute("cate_en","Award");
        model.addAttribute("cate_kor","수상");
        return "contentlist.html";
    }
}
