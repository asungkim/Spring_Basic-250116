package com.example.demo.domain.wiseSaying.service;

import com.example.demo.domain.wiseSaying.entity.WiseSaying;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class WiseSayingService {
    private final List<WiseSaying> wiseSayingList;
    private int lastId;

    public WiseSayingService() {
        this.wiseSayingList = new ArrayList<>();
        this.lastId = 0;

        WiseSaying wiseSaying1 = WiseSaying.builder()
                .id(++lastId)
                .content("명언1")
                .author("제목1")
                .build();

        WiseSaying wiseSaying2 = WiseSaying.builder()
                .id(++lastId)
                .content("명언2")
                .author("제목2")
                .build();

        wiseSayingList.add(wiseSaying1);
        wiseSayingList.add(wiseSaying2);
    }

    public List<WiseSaying> getAllItems() {
        return wiseSayingList;
    }

    public Optional<WiseSaying> getItem(int id) {
        return wiseSayingList.stream()
                .filter(w->w.getId()==id)
                .findFirst();
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = WiseSaying.builder()
                .id(++lastId)
                .content(content)
                .author(author)
                .build();

        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }
}
