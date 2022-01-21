package com.hyunsdb.hambook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class BookImg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iid;

    @Column(length = 50, nullable = false)
    private String imgName;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    private String fileFullPath;


    public void changeBookImg(String imgName, String filePath, String fileFullPath) {
        this.imgName = imgName;
        this.filePath = filePath;
        this.fileFullPath = fileFullPath;
    }
}
