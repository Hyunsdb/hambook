package com.hyunsdb.hambook.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class BookImg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String imgName;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bid")
    private Book book;
}
