package com.hyunsdb.hambook.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rid;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    //평점
    private int grade;

    //리뷰내용
    private String content;

    public void changeGrade(int grade){
        this.grade = grade;
    }

    public void changeContent(String content){
        this.content = content;
    }

    @Builder
    public Review(Long rid, Book book, User user, int grade, String content) {
        this.rid = rid;
        this.book = book;
        this.user = user;
        this.grade = grade;
        this.content = content;
    }
}
