package com.example.shortenurlservice.application;

import com.example.shortenurlservice.domain.LackShortenUrlException;
import com.example.shortenurlservice.domain.ShortenUrl;
import com.example.shortenurlservice.domain.ShortenUrlRepository;
import com.example.shortenurlservice.presentation.ShortenUrlRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShortenUrlServiceImplUnitTest {

    @Mock
    private ShortenUrlRepository shortenUrlRepository;
    @InjectMocks
    private ShortenUrlServiceImpl shortenUrlService;

    @Test
    @DisplayName("단축 URL이 계속 중복되면 LackShortenUrlException이 발생해야 한다.")
    void throwLackShortenUrlException(){
        ShortenUrlRequestDTO shortenUrlRequestDTO = new ShortenUrlRequestDTO(null);

        when(shortenUrlRepository.findShortenUrlByShortenUrlKey(any())).thenReturn(new ShortenUrl(null, null, null));

        assertThrows(LackShortenUrlException.class, () -> {
            shortenUrlService.generateShortenUrl(shortenUrlRequestDTO);
        });
    }
}
