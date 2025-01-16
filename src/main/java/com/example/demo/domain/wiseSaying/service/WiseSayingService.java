package com.example.demo.domain.wiseSaying.service;

import com.example.demo.domain.wiseSaying.entity.WiseSaying;
import com.example.demo.domain.wiseSaying.repository.WiseSayingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;


    public List<WiseSaying> getAllItems() {
        return wiseSayingRepository.findAll();
    }

    public Optional<WiseSaying> getItem(int id) {
        return wiseSayingRepository.findById(id);
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = WiseSaying.builder()
                .content(content)
                .author(author)
                .build();

        return wiseSayingRepository.save(wiseSaying);

    }

    public boolean deleteById(int id) {
        return wiseSayingRepository.deleteById(id);
    }

    public WiseSaying modify(int id, String content, String author) {
        Optional<WiseSaying> opWiseSaying = getItem(id);

        if (opWiseSaying.isEmpty()) {
            throw new IllegalArgumentException("해당 id의 명언이 없습니다.");
        }

        WiseSaying wiseSaying = opWiseSaying.get();
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        return wiseSaying;
    }
}
