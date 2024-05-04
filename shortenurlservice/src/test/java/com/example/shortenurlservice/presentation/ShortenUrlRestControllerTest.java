package com.example.shortenurlservice.presentation;

import com.example.shortenurlservice.application.ShortenUrlServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ShortenUrlRestController.class)
class ShortenUrlRestControllerTest {

    @MockBean
    private ShortenUrlServiceImpl shortenUrlService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("원래의 URL로 리다이렉트 되어야 한다.")
    void redirectTest() throws Exception {
        String expectedOriginUrl = "http://www.naver.com";

        when(shortenUrlService.getOriginUrl(any())).thenReturn(expectedOriginUrl);

        mockMvc.perform(get("/any-key"))
                .andExpect(status().isMovedPermanently())
                .andExpect(header().string("Location", expectedOriginUrl));

    }

}