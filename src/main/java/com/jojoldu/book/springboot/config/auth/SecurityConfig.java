package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;


@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserTypesOAuth2UserService customUserTypesOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션들 disable
                .and()
                    .authorizeRequests() // url별 권한 관리를 설정하는 옵션의 시작점
                    // 권한 관리 대상 지정 옵션, 지정된 URL들 전체 열람 권한
                    .antMatchers("/","/css/**","/images/**", "/js/**","/h2-console/**").permitAll()
                    // USER권한을 가진 사람만 가능
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated() // anyRequest: 설정된 값 이외의 나머지 URL, authenticated(): 인증된 사용자들만 허용
                .and()
                    .logout() // 로그아웃 기능에 대한 설정 진입
                    .logoutSuccessUrl("/") // 로그아웃 성공시 / 주소로 이동
                .and()
                .oauth2Login() // oauth2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint() // OAuth2로그인 성공 이후 사용자 정보를 가져올때 설정 담당
                .userService(customUserTypesOAuth2UserService); // 리소스 서버에서 사용자 정보를 가져온 사태에서 추가로 진행하고자하는 기능 명시 가능
    }
}
