package com.example.shortenurlservice.application;

import com.example.shortenurlservice.domain.LackShortenUrlException;
import com.example.shortenurlservice.domain.NotFoundShortenUrlException;
import com.example.shortenurlservice.domain.ShortenUrl;
import com.example.shortenurlservice.domain.ShortenUrlRepository;
import com.example.shortenurlservice.presentation.ShortenUrlInformationDTO;
import com.example.shortenurlservice.presentation.ShortenUrlRequestDTO;
import com.example.shortenurlservice.presentation.ShortenUrlResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortenUrlServiceImpl implements ShortenUrlService{

    private static final Integer CREATE_COUNT = 10;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final ShortenUrlRepository shortenUrlRepository;

    @Override
    public ShortenUrlResponseDTO generateShortenUrl(ShortenUrlRequestDTO shortenUrlRequestDTO) {
        String originalUrl = shortenUrlRequestDTO.getOriginalUrl();

        String shortenUrlKey = getUniqueShortenUrlKey();

        ShortenUrl shortenUrl = ShortenUrl.builder()
                .originalUrl(originalUrl)
                .shortenUrlKey(shortenUrlKey)
                .redirectCount(0L).build();
        shortenUrlRepository.saveShortenUrl(shortenUrl);


        ShortenUrlResponseDTO shortenUrlResponseDTO = ShortenUrlResponseDTO.builder()
                .shortenUrl(shortenUrl).build();

        return shortenUrlResponseDTO;
    }

    @Override
    public ShortenUrlInformationDTO getShortenUrlInformationByShortenUrlKey(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);
        if(shortenUrl == null) throw new NotFoundShortenUrlException();

        ShortenUrlInformationDTO shortenUrlInformationDTO = ShortenUrlInformationDTO.toDTO(shortenUrl);
        return shortenUrlInformationDTO;
    }

    // 리다이렉트
    @Override
    public String getOriginUrl(String shortenUrlKey) {
        ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);
        if(shortenUrl == null) throw new NotFoundShortenUrlException();

        shortenUrl.incrementCount();

        String originUrl = shortenUrl.getOriginalUrl();

        return originUrl;
    }

    private String getUniqueShortenUrlKey(){
        final int MAX_RETRY_COUNT = 5;
        int count = 0;
        while(count++ < MAX_RETRY_COUNT){
            String shortenUrlKey = ShortenUrl.generateShortenUrlKey();

            ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

            if(shortenUrl == null) return shortenUrlKey;
        }

        throw new LackShortenUrlException();
    }
}
