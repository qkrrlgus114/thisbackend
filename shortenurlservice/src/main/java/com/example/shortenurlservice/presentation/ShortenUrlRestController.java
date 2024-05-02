package com.example.shortenurlservice.presentation;

import com.example.shortenurlservice.application.ShortenUrlServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShortenUrlRestController {

    private final ShortenUrlServiceImpl shortenUrlService;

    // url 생성 메서드
    @PostMapping("/shortenUrl")
    public ResponseEntity<ShortenUrlResponseDTO> createShortenUrl(@Valid @RequestBody ShortenUrlRequestDTO shortenUrlRequestDTO){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{shortenUrlKey}")
    public ResponseEntity<?> redirectShortenUrl(@PathVariable String shortenUrlKey){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/shortenUrl/{shortenUrlKey}")
    public ResponseEntity<ShortenUrlInformationDTO> getShortenUrlInformation(@PathVariable String shortenUrlKey){
        return ResponseEntity.ok().body(null);
    }
}
