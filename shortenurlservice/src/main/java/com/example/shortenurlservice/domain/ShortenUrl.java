package com.example.shortenurlservice.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
public class ShortenUrl {
    private String originalUrl;
    private String shortenUrlKey;
    private Long redirectCount = 0L;

    @Builder
    public ShortenUrl(String originalUrl, String shortenUrlKey, Long redirectCount) {
        this.originalUrl = originalUrl;
        this.shortenUrlKey = shortenUrlKey;
        this.redirectCount = redirectCount;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }

    public static String generateShortenUrlKey(){
        String base56Characters = "23456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int count = 0; count < 8; count++){
            int base56CharactersIndex = random.nextInt(0, base56Characters.length());
            char base56Character = base56Characters.charAt(base56CharactersIndex);
            sb.append(base56Character);
        }

        return sb.toString();
    }

    public void incrementCount(){
        this.redirectCount++;
    }
}
