package com.hyunsdb.hambook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookSearchDto {
    private String searchBy;
    private String searchQuery;
}
