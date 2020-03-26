package com.example.mysite.Controller;

import com.example.mysite.Entity.Content;
import com.example.mysite.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SStackController {
    @Autowired
    ContentRepository repo;

    @GetMapping("/stacks")
    public String awards(Model model){
        List<Content> contentList=repo.findAllByCategory("stack", Sort.by("createdate").descending());
        model.addAttribute("contentList",contentList);
        model.addAttribute("cate_en","Stacks");
        model.addAttribute("cate_kor","기술 스택");
        return "contentlist.html";
    }
}
