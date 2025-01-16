package com.example.demo.domain.home.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private int age=0;


    @GetMapping("/")
    @ResponseBody // 메서드에 리턴값을 브라우저에 보여준다
    public String home() {
        return "hello";
    }

    @GetMapping("/introduce")
    @ResponseBody
    public String introduce() {
        return "안녕하세요 저는 홍길동입니다.";
    }

    @GetMapping("/ageUp")
    @ResponseBody
    public int ageUp() {
        age++;
        return age;
    }
}
