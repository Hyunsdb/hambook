package com.hyunsdb.hambook.dto;

import com.hyunsdb.hambook.entity.Comment;
import com.hyunsdb.hambook.entity.Post;
import com.hyunsdb.hambook.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentDto {
    private long cid;

    //post
    private long pid;

    //user
    private long uid;

    private String content;

    private LocalDateTime regDate, modDate;

    @Builder
    public Comment toEntity(){
        return Comment.builder()
                .cid(cid)
                .post(Post.builder().pid(pid).build())
                .user(User.builder().uid(1052L).build())
                .content(content)
                .build();

    }
}
