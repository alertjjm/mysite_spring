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
public class LicenseController {
    @Autowired
    ContentRepository repo;

    @GetMapping("/licenses")
    public String awards(Model model){
        List<Content> contentList=repo.findAllByCategory("license", Sort.by("createdate").descending());
        model.addAttribute("contentList",contentList);
        model.addAttribute("cate_en","Licenses");
        model.addAttribute("cate_kor","자격증");
        return "contentlist.html";
    }
}
