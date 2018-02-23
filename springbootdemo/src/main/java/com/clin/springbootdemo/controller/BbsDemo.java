package com.clin.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbsDemo {
    @RequestMapping("/")
    String index() {
        return "welcome to chen";
    }
}
