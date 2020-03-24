package com.example.mysite.Repository;

import com.example.mysite.Entity.Content;
import com.example.mysite.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByUsername(String username);
}
