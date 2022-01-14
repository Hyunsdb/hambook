package com.hyunsdb.hambook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookImgDto {
    private Long id;
    private String imgName;
    private String filePath;
    private String fileFullPath;

    @Builder
    public BookImgDto(Long id, String imgName, String filePath, String fileFullPath) {
        this.id = id;
        this.imgName = imgName;
        this.filePath = filePath;
        this.fileFullPath = fileFullPath;
    }
}
