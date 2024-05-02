package com.example.shortenurlservice.application;

import com.example.shortenurlservice.domain.ShortenUrl;
import com.example.shortenurlservice.presentation.ShortenUrlRequestDTO;

public interface ShortenUrlService {
    // url 변환 메서드
    ShortenUrl changeShortenUrl(ShortenUrlRequestDTO shortenUrlRequestDTO);

    // url 단축 메서드
    boolean checkShortenUrl();
}
