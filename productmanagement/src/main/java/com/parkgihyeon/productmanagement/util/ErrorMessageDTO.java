package com.parkgihyeon.productmanagement.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ErrorMessageDTO {
    private String message;

    public ErrorMessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
