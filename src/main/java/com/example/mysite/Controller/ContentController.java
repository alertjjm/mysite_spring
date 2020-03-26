package com.example.mysite.Controller;

import com.example.mysite.Entity.Content;
import com.example.mysite.Repository.ContentRepository;
import com.example.mysite.Service.ContentService;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ServletContext servletContext;
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
    public String contentupdate(Model model,@PathVariable("id") int id){
        Content content=repo.findById(id).get(0);
        model.addAttribute("content",content);
        return "update.html";
    }
    @PostMapping(value = "/update/{id}")
    public String postcontentupdate(HttpServletRequest body,@RequestPart MultipartFile file,@PathVariable("id") int id) throws IOException{
        Content result=repo.findById(id).get(0);
        MultipartFile imgfile=null;
        String ct=(String)body.getParameter("category");
        String tt=(String)body.getParameter("title");
        String ds=(String)body.getParameter("description");
        String ld=(String)body.getParameter("longdescription");
        String savedname=null;
        imgfile=file;
        result.setCategory(ct);//String category,String title,String description,String longdescription
        result.setTitle(tt);
        result.setDescription(ds);
        result.setLongdescription(ld);
        if(!imgfile.isEmpty()){
            //String rootpath=servletContext.getRealPath("C:\\Users\\windows10\\Desktop\\mysite\\src\\main\\resources\\static\\image");
            savedname=imgfile.getOriginalFilename();
            String up=body.getSession().getServletContext().getRealPath("/")+"mysitestorage";
            File target=new File(up,savedname);
            FileCopyUtils.copy(imgfile.getBytes(),target);
            result.setPicurl(savedname);
        }
        repo.save(result);
        String op=(String) body.getParameter("category");
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
        return "redirect:/.reload";
    }


    @GetMapping(value = "/delete/{id}")
    public String deletecontent(@PathVariable("id") int id){
        Content content=repo.findById(id).get(0);
        String op=content.getCategory();
        serv.deleteContent(id);
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
        return "redirect:/.reload";
    }
    @GetMapping(value = "/create")
    public String createcontent(){
        return "create.html";
    }
    @PostMapping(value = "/create")
    public String postcreatecontent(HttpServletRequest body,@RequestPart MultipartFile file) throws IOException {
        MultipartFile imgfile=null;
        String ct=(String)body.getParameter("category");
        String tt=(String)body.getParameter("title");
        String ds=(String)body.getParameter("description");
        String ld=(String)body.getParameter("longdescription");
        String savedname=null;
        Content result=null;
        imgfile=file;
        result=serv.createContent(ct,tt,ds,ld);//String category,String title,String description,String longdescription
        if(!imgfile.isEmpty()){
            savedname=imgfile.getOriginalFilename();
            String up=body.getSession().getServletContext().getRealPath("/")+"mysitestorage";
            File target=new File(up,savedname);
            FileCopyUtils.copy(imgfile.getBytes(),target);
            result.setPicurl(savedname);
        }
        repo.save(result);
        String op=(String) body.getParameter("category");
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
        return "redirect:/.reload";
    }
}
