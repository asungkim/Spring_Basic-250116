package com.example.demo.domain.wiseSaying.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class WiseSaying {
    private int id;
    @Setter
    private String content;
    @Setter
    private String author;


}
