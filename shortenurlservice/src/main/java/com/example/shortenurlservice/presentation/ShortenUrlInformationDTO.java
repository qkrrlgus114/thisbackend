package com.example.shortenurlservice.presentation;

import com.example.shortenurlservice.domain.ShortenUrl;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShortenUrlInformationDTO {
    private String originalUrl;
    private String shortenUrlKey;
    private Long redirectCount;

    @Builder
    public ShortenUrlInformationDTO(String originalUrl, String shortenUrlKey, Long redirectCount) {
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

    public static ShortenUrlInformationDTO toDTO(ShortenUrl shortenUrl){
        return ShortenUrlInformationDTO.builder()
                .originalUrl(shortenUrl.getOriginalUrl())
                .shortenUrlKey(shortenUrl.getShortenUrlKey())
                .redirectCount(shortenUrl.getRedirectCount()).build();
    }
}
