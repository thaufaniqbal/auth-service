package com.banyuijio.auth.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor
public enum HttpStatusCode {
    UNAUTHORIZED(200000, HttpStatus.UNAUTHORIZED, false, "UNAUTHORIZED."),
    DATA_NOT_FOUND (200001, HttpStatus.NO_CONTENT, false, "Data Not Found"),
    MISSING_MANDATORY_PROPERTY (200002, HttpStatus.BAD_REQUEST, true, "Missing mandatory property %s"),
    INVALID_DATA_TYPE(200003, HttpStatus.BAD_REQUEST,true,"Invalid data type for property %s"),
    MAXIMUM_LENGTH_EXCEEDED (200004, HttpStatus.BAD_REQUEST, true, "Maximum length for property %s is %s"),
    MINIMUM_LENGTH_EXCEEDED (200005, HttpStatus.BAD_REQUEST, true, "Minimum length for property %s is %s"),
    DATA_ALREADY_EXIST (200006, HttpStatus.BAD_REQUEST, true, "Data Already Exist for %s"),
    INVALID_DATA_INPUT (200007, HttpStatus.BAD_REQUEST, true, "Invalid data input for %s"),
    DATA_NOT_FOUND_FOR (200008, HttpStatus.BAD_REQUEST, true, "Data Not Found for %s");

    private final int code;
    private final HttpStatus status;
    private final boolean parameterized;
    private final String format;
}
