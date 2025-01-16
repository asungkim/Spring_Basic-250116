package com.example.demo.domain.home.controller;


import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@ResponseBody
public class HomeController {

    private int age = 0;

    @Autowired
    private List<Integer> numList;

    @Autowired
    private List<Integer> numList2;

    @GetMapping("/numList")
    public List<Integer> getNumList() {
        return numList;
    }

    @GetMapping("/numList2")
    public List<Integer> getNumList2() {
        return numList2;
    }


    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/introduce")
    public String introduce() {
        return "안녕하세요 저는 홍길동입니다.";
    }

    @GetMapping("/ageUp")
    public int ageUp() {
        age++;
        return age;
    }

    @GetMapping("/byte")
    public byte getByte() {
        return 1;
    }

    @GetMapping("/short")
    public short getShort() {
        return 1;
    }

    @GetMapping("/long")
    public long getLong() {
        return 1;
    }

    @GetMapping("/float")
    public float getFloat() {
        return 3.14f;
    }

    @GetMapping("/double")
    public double getDouble() {
        return 3.14;
    }

    @GetMapping("/char")
    public char getChar() {
        return '안';
    }

    @GetMapping("/boolean")
    public boolean getBoolean() {
        return true;
    }

    @GetMapping("/arr")
    public String[] getArr() {
        return new String[]{"a", "b", "c"};
    }

    @GetMapping("/list")
    public List<String> getList() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/map")
    public Map<String, String> getMap() {
        return Map.of("a", "b", "c", "d");
    }

    @GetMapping("/article")
    public Article getArticle() {
        return Article.builder()
                .body("내용")
                .title("제목")
                .isDeleted(true)
                .build();
    }

    @GetMapping("/mapList")
    public List<Map<String, String>> getMapList() {
        return List.of(
                Map.of("k1", "v1", "k2", "v2"),
                Map.of("k3", "v3", "k4", "v4")
        );
    }

    @GetMapping("/articleList")
    public List<Article> getArticleList() {
        return List.of(
                Article.builder().title("제목1").body("내용1").isDeleted(false).build(),
                Article.builder().title("제목2").body("내용2").isDeleted(false).build()
        );
    }

    @GetMapping("/articleList.html")
    public String getArticleListHtml() {
        Article a1 = Article.builder().title("제목1").body("내용1").isDeleted(false).build();
        Article a2 = Article.builder().title("제목2").body("내용2").isDeleted(false).build();

        List<Article> articleList = List.of(a1, a2);
        String lis = articleList.stream()
                .map(a -> "<li>%s</li>".formatted(a.getTitle()))
                .collect(Collectors.joining());

        return "<ul>" + lis + "</ul>"; // 자바에서 하지 않고 html에서 하려고 template(자바로 작동하는 html)
    }

}

@Getter
@Builder
class Article {
    @Builder.Default
    private int id = 1;
    private final String title;
    private final String body;
    private boolean isDeleted;
}