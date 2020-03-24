package com.example.mysite.Dto;

import com.example.mysite.Entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private int id;
    private String username;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    public MemberEntity toEntity(){
        return MemberEntity.builder().id(id).username(username).password(password).build();
    }
    @Builder
    public MemberDto(int id, String username,String password){
        this.id=id;
        this.username=username;
        this.password=password;
    }
}
