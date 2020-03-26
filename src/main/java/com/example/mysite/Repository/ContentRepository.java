package com.example.mysite.Repository;

import com.example.mysite.Entity.Content;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.OrderBy;
import java.util.List;
public interface ContentRepository extends CrudRepository<Content,Long> {
    List<Content> findAllByCategory(String category, Sort sort);
    List<Content> findById(int id);
}
