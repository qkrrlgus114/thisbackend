package com.example.shortenurlservice.application;

import com.example.shortenurlservice.infrastructure.ShortenUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class GeneratorShortenUrl {

    private final ShortenUrlRepository shortenUrlRepository;

    private static final String STRING_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();
    private static final Integer STRING_KEY_LENGTH = 8;
    private static final Integer GENERATOR_COUNT = 10; // 생성 시도 횟수
    private static final String SHORTEN_URL_PREFIX = "https://bit.ly/";

    public String generateRandomString(){
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<GENERATOR_COUNT; t++){
            sb.setLength(0);
            sb.append(SHORTEN_URL_PREFIX);
            for(int i=0; i<STRING_KEY_LENGTH; i++){
                int randomIndex = random.nextInt(STRING_KEY.length());
                sb.append(STRING_KEY.charAt(randomIndex));
            }
            
            if(!shortenUrlRepository.checkExistShortenUrl(sb.toString())){
                return sb.toString();
            }
        }
        
        // 못만들었으니 예외 처리

    }

}
