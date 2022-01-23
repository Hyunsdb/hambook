package com.hyunsdb.hambook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookImgDto {
    private Long iid;
    private String imgName;
    private String filePath;
    private String fileFullPath;

    @Builder
    public BookImgDto(Long iid, String imgName, String filePath, String fileFullPath) {
        this.iid = iid;
        this.imgName = imgName;
        this.filePath = filePath;
        this.fileFullPath = fileFullPath;
    }
}
