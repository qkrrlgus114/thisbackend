package com.example.shortenurlservice.application;

import com.example.shortenurlservice.domain.ShortenUrl;
import com.example.shortenurlservice.presentation.ShortenUrlInformationDTO;
import com.example.shortenurlservice.presentation.ShortenUrlRequestDTO;
import com.example.shortenurlservice.presentation.ShortenUrlResponseDTO;

public interface ShortenUrlService {

    // url 생성
    ShortenUrlResponseDTO generateShortenUrl(ShortenUrlRequestDTO shortenUrlRequestDTO);
    // url 조회
    ShortenUrlInformationDTO getShortenUrlInformationByShortenUrlKey(String shortenUrlKey);
    // url 리다이렉트
    String getOriginUrl(String shortenUrlKey);
}
