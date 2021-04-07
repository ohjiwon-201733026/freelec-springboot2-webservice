package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser { // 세션에 사용자 정보를 저장하기 위한 Dto 클래스
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }
}
