package com.banyuijio.auth.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CrudTypeCode {
    READ(0, "read"),
    CREATE(1, "create"),
    EDIT(2, "read"),
    DELETE(3, "update");
    private final int code;
    private final String description;
}
