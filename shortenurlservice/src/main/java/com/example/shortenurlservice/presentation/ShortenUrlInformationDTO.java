package com.example.shortenurlservice.presentation;

public class ShortenUrlInformationDTO {
    private String originalUrl;
    private String shortenUrlKey;
    private Long redirectCount;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }
}
