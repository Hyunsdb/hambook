package com.hyunsdb.hambook.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long cid;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Builder
    public Comment(long cid, String content, User user, Post post) {
        this.cid = cid;
        this.content = content;
        this.user = user;
        this.post = post;
    }
}
