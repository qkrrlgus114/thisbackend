package com.example.shortenurlservice.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShortenUrl {
    private String originalUrl;
    private String shortenUrl;
    private Long redirectCount;

    @Builder
    public ShortenUrl(String originalUrl, String shortenUrl, Long redirectCount) {
        this.originalUrl = originalUrl;
        this.shortenUrl = shortenUrl;
        this.redirectCount = redirectCount;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrl() {
        return shortenUrl;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }
}
