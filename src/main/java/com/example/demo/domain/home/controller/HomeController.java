package com.example.demo.domain.home.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody // 메서드에 리턴값을 브라우저에 보여준다
    public String home() {
        return "hello";
    }
}
