package com.example.demo.domain.wiseSaying.controller;

import com.example.demo.domain.wiseSaying.entity.WiseSaying;
import com.example.demo.domain.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WiseSayingController {
    private final WiseSayingService wiseSayingService;


    @GetMapping("/wiseSayings")
    public List<WiseSaying> getWiseSayings() {
        return wiseSayingService.getAllItems();
    }


    @GetMapping("/wiseSayings/write")
    public WiseSaying writeWiseSaying(String content, @RequestParam(defaultValue = "작자미상") String author) {
        return wiseSayingService.write(content, author);
    }

    // GET /wiseSayings -> 명언들을 가져와라
    // GET /wiseSayings/1 -> 명언들 중에서 1번 가져와라


    @GetMapping("/wiseSayings/{id}")
    public WiseSaying getItem(@PathVariable int id) {
        return wiseSayingService.getItem(id).orElse(null);
    }

    @GetMapping("/wiseSayings/{id}/delete")
    public boolean deleteItem(@PathVariable int id) {
        return wiseSayingService.deleteById(id);
    }

    @GetMapping("/wiseSayings/{id}/modify")
    public WiseSaying modifyItem(@PathVariable int id,String content,String author) {
        return wiseSayingService.modify(id,content,author);
    }
}
