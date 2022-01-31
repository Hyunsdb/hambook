package com.hyunsdb.hambook.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;

    private String title;

    private String content;

    private String writer;

    @Builder
    public Post(Long pid, String title, String content, String writer) {
        this.pid = pid;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
