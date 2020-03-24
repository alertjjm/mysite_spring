package com.example.mysite.Service;

import com.example.mysite.Dto.MemberDto;
import com.example.mysite.Entity.MemberEntity;
import com.example.mysite.Entity.Role;
import com.example.mysite.Repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;
    @Transactional
    public int joinUser(MemberDto memberDto){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> userEntityWrapper=memberRepository.findByUsername(username);
        MemberEntity userEntity=userEntityWrapper.get();
        List<GrantedAuthority> authorities=new ArrayList<>();
        if(("alertjjm").equals(username)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
            System.out.println("추가");
        }else{
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }
        return new User(userEntity.getUsername(),userEntity.getPassword(),authorities);
    }
}
