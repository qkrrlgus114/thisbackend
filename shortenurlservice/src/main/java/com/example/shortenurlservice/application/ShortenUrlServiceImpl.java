package com.example.shortenurlservice.application;

import com.example.shortenurlservice.domain.ShortenUrl;
import com.example.shortenurlservice.infrastructure.ShortenUrlRepository;
import com.example.shortenurlservice.presentation.ShortenUrlRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortenUrlServiceImpl implements ShortenUrlService{

    private final ShortenUrlRepository shortenUrlRepository;
    private final GeneratorShortenUrl generatorShortenUrl;
    private static final Integer CREATE_COUNT = 10;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";



    @Override
    public ShortenUrl changeShortenUrl(ShortenUrlRequestDTO shortenUrlRequestDTO) {
        // dto를 받아서 변환함.
        String shortenUrlStr = generatorShortenUrl.generateRandomString();
        ShortenUrl shortenUrl = ShortenUrlRequestDTO.toEntity(shortenUrlRequestDTO, shortenUrlStr);
        shortenUrlRepository.

        return null;
    }

    @Override
    public boolean checkShortenUrl() {
        return false;
    }

}
