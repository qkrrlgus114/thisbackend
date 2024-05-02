package com.example.shortenurlservice.presentation;

import com.example.shortenurlservice.domain.ShortenUrl;

public class ShortenUrlResponseDTO {
    private String originalUrl;
    private String shortenUrlKey;

    public ShortenUrlResponseDTO(ShortenUrl shortenUrl){
        this.originalUrl = shortenUrl.getOriginalUrl();
        this.shortenUrlKey = shortenUrl.getShortenUrl();
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }
}
