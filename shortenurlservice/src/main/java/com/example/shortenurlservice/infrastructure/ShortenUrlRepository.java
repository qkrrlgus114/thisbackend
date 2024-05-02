package com.example.shortenurlservice.infrastructure;

import com.example.shortenurlservice.domain.ShortenUrl;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ShortenUrlRepository {

    ConcurrentHashMap<String, String> database = new ConcurrentHashMap<>();

    // url이 이미 존재하는지 확인
    public boolean checkExistShortenUrl(String shortenUrl){
        String url = database.get(shortenUrl);
        if(url == null) return false;
        return true;
    }

    // map db에 저장
    public boolean savedShortenUrl(ShortenUrl shortenUrl){
        if(database.containsKey(shortenUrl.getShortenUrl())){
            return false;
        }
        database.put(sh)
    }

}
