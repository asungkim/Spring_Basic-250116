package com.example.demo.domain.wiseSaying.controller;

import com.example.demo.domain.wiseSaying.entity.WiseSaying;
import com.example.demo.domain.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WiseSayingController {
    private final WiseSayingService wiseSayingService;


    @GetMapping("/wiseSayings")
    public List<WiseSaying> getWiseSayings() {
        return wiseSayingService.getAllItems();
    }


    @GetMapping("wiseSaying/write")
    public WiseSaying writeWiseSaying(String content, @RequestParam(defaultValue = "작자미상") String author) {
        return wiseSayingService.write(content, author);
    }

    // GET /wiseSayings -> 명언들을 가져와라
    // GET /wiseSayings/1 -> 명언들 중에서 1번 가져와라


    @GetMapping("wiseSayings/{id}")
    public WiseSaying getItem(@PathVariable int id) {
        return wiseSayingService.getItem(id).orElse(null);
    }


}
