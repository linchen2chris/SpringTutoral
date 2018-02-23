package com.clin.springbootdemo.controller;

import com.clin.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    private UserService userService;

    @RequestMapping("login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request) {
        return new ModelAndView();
    }

}
