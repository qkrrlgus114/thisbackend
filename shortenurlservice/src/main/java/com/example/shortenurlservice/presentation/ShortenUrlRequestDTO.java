package com.example.shortenurlservice.presentation;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShortenUrlRequestDTO {
    private String originalUrl;

    public ShortenUrlRequestDTO(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
