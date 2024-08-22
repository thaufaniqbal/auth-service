package com.banyuijio.auth.util;

import com.banyuijio.auth.enums.HttpStatusCode;
import com.banyuijio.auth.exception.HttpStatusException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GlobalValidator {

    public void validateRequestLength(String property ,Integer minLength, Integer maxLength) {
        int length = property.length();
        if (length < minLength || length > maxLength) {
            throw new HttpStatusException(
                    length < minLength ? HttpStatusCode.MINIMUM_LENGTH_EXCEEDED : HttpStatusCode.MAXIMUM_LENGTH_EXCEEDED,
                    property,
                    length < minLength ? minLength : maxLength);
        }
    }
    public void validateRequestMandatory(String property){
        if (property.isEmpty()){
            throw new HttpStatusException(HttpStatusCode.MISSING_MANDATORY_PROPERTY, property);
        }
    }
    public void validateRequestMandatory(UUID uuid, String property){
        if (Objects.isNull(uuid)){
            throw new HttpStatusException(HttpStatusCode.MISSING_MANDATORY_PROPERTY, property);
        }
    }
    public void validateIntegerRequest(Integer value, String property) {
        if (value == null) {
            throw new HttpStatusException(HttpStatusCode.MISSING_MANDATORY_PROPERTY, property);
        }
    }
    public void validateIntegerRequest(Integer value, Integer minValue, Integer maxValue, String property) {
        validateIntegerRequest(value, property);
        if (value < minValue || value > maxValue) {
            throw new HttpStatusException(
                    value < minValue ? HttpStatusCode.MINIMUM_LENGTH_EXCEEDED : HttpStatusCode.MAXIMUM_LENGTH_EXCEEDED,
                    property,
                    value < minValue ? minValue : maxValue);
        }
    }
}
