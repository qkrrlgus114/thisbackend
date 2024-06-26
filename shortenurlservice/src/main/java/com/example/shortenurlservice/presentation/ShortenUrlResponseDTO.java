package com.example.shortenurlservice.presentation;

import com.example.shortenurlservice.domain.ShortenUrl;
import lombok.Builder;

public class ShortenUrlResponseDTO {
    private String originalUrl;
    private String shortenUrlKey;

    @Builder
    public ShortenUrlResponseDTO(ShortenUrl shortenUrl){
        this.originalUrl = shortenUrl.getOriginalUrl();
        this.shortenUrlKey = shortenUrl.getShortenUrlKey();
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }
}
