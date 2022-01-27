package com.hyunsdb.hambook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostFormDto {
    private Long pid;
    private String title;
    private String content;
    private String author;
}
