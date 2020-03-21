package com.example.mysite.Service;

import com.example.mysite.Entity.Content;
import com.example.mysite.Repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository repo;
    public Content getContent(int id){
        return repo.findById(id).get(0);
    }
    public Content createContent(String category,String title,String description,String longdescription){
        Content content=new Content(category,title,description,longdescription);
        return repo.save(content);
    }
    public Content updateContent(int id, String category, String title, String description){
        Content content=repo.findById(id).get(0);
        content.setCategory(category);
        content.setTitle(title);
        content.setDescription(description);
        return repo.save(content);
    }
    public boolean deleteContent(int id,String password){
        Content content=repo.findById(id).get(0);
        if(!password.equals("sdr2936"))
            return false;
        repo.delete(content);
        return true;
    }
}
