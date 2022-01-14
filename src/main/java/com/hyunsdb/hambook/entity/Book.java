package com.hyunsdb.hambook.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Book extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bid;

    private String name;

    private String writer;

    private String publisher;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private BookImg bookImg;

    @Builder
    public Book(Long bid, String name, String writer, String publisher) {
        this.bid = bid;
        this.name = name;
        this.writer = writer;
        this.publisher = publisher;
    }

}
