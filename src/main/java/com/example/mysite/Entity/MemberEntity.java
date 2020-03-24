package com.example.mysite.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20,nullable = false,name = "username",unique = true)
    private String username;
    @Column(length = 100,nullable = false,name = "password")
    private String password;

    @Builder
    public MemberEntity(int id, String username,String password){
        this.id=id;
        this.username =username;
        this.password=password;
    }
}
