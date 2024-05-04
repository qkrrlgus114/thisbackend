package com.example.shortenurlservice.presentation;

import com.example.shortenurlservice.application.ShortenUrlServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class ShortenUrlRestController {

    private final ShortenUrlServiceImpl shortenUrlService;

    // url 생성 메서드
    @PostMapping("/shortenUrl")
    public ResponseEntity<ShortenUrlResponseDTO> createShortenUrl(@Valid @RequestBody ShortenUrlRequestDTO shortenUrlRequestDTO){
        ShortenUrlResponseDTO shortenUrlResponseDTO = shortenUrlService.generateShortenUrl(shortenUrlRequestDTO);

        return ResponseEntity.ok().body(shortenUrlResponseDTO);
    }

    // 리다이렉트
    @GetMapping("/{shortenUrlKey}")
    public ResponseEntity<?> redirectShortenUrl(@PathVariable String shortenUrlKey){

        String originUrl = shortenUrlService.getOriginUrl(shortenUrlKey);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(originUrl));

        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    // url 조회
    @GetMapping("/shortenUrl/{shortenUrlKey}")
    public ResponseEntity<ShortenUrlInformationDTO> getShortenUrlInformation(@PathVariable String shortenUrlKey){
        ShortenUrlInformationDTO shortenUrlInformationDTO = shortenUrlService.getShortenUrlInformationByShortenUrlKey(shortenUrlKey);
        return ResponseEntity.ok().body(shortenUrlInformationDTO);
    }
}
