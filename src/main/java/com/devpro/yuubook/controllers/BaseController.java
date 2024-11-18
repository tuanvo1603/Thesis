package com.devpro.yuubook.controllers;

import com.devpro.yuubook.models.bo.Oauth2UserDetail;
import com.devpro.yuubook.models.entities.User;
import com.devpro.yuubook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public abstract class BaseController {

    @Autowired
    private UserService userService;

    @ModelAttribute("userLogin")
    public User userLogin() {
        User user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) return null;

        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            User u = (User) authentication.getPrincipal();
            user = userService.getUserByEmail(u.getEmail());
        }

        if (authentication instanceof OAuth2AuthenticationToken) {
            Oauth2UserDetail oauth2UserDetail = (Oauth2UserDetail) authentication.getPrincipal();
            user = userService.getUserByEmail(oauth2UserDetail.getEmail());
        }
        return user;
    }
    
}
