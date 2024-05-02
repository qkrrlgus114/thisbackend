package com.example.shortenurlservice.presentation;

import com.example.shortenurlservice.domain.ShortenUrl;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public class ShortenUrlRequestDTO {
    @NotBlank
    @URL(regexp = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)")
    private String originalUrl;

    public ShortenUrlRequestDTO(String originalUrl) {
        this.originalUrl = originalUrl;
    }


}
