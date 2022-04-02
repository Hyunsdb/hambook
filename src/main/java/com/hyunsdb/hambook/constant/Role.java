package com.hyunsdb.hambook.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER","사용자"),
    WRITER("ROLE_WRITER","작가");


    private final String key;
    private final String title;
}
