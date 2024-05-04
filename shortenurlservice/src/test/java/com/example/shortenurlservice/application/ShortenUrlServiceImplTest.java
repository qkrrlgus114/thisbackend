package com.example.shortenurlservice.application;

import com.example.shortenurlservice.domain.NotFoundShortenUrlException;
import com.example.shortenurlservice.presentation.ShortenUrlRequestDTO;
import com.example.shortenurlservice.presentation.ShortenUrlResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShortenUrlServiceImplTest {

    @Autowired
    private ShortenUrlServiceImpl shortenUrlService;

    @Test
    @DisplayName("URL을 단축한 후 단축된 URL 키로 조회하면 원래 URL이 조회되어야 한다.")
    void shortenUrlAddTest(){
        // given
        String expectedOriginalUrl = "https://www.naver.com";
        ShortenUrlRequestDTO shortenUrlRequestDTO = new ShortenUrlRequestDTO(expectedOriginalUrl);
        ShortenUrlResponseDTO shortenUrlResponseDTO = shortenUrlService.generateShortenUrl(shortenUrlRequestDTO);
        String shortenUrlKey = shortenUrlResponseDTO.getShortenUrlKey();

        // when
        String originUrl = shortenUrlService.getOriginUrl(shortenUrlKey);

        // then
        assertEquals(expectedOriginalUrl, originUrl);
    }

    @Test
    @DisplayName("존재하지 않는 단축 URL로 존재하는 경우 NotFoundShortenUrlException이 발생해야 한다.")
    void notFoundShortenUrlException(){
        // given
        String shortenUrlKey = "123asdgf";

        // when && then
        assertThrows(NotFoundShortenUrlException.class, () -> {
            shortenUrlService.getShortenUrlInformationByShortenUrlKey(shortenUrlKey);
        });

    }

}