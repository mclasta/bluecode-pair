package com.bluecode.pair.services;

import com.bluecode.pair.models.ShortUrls;
import com.bluecode.pair.repositories.ShortUrlsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlsService {

    private ShortUrlsRepository shortUrlsRepository;

    @Autowired
    public ShortUrlsService( ShortUrlsRepository shortUrlsRepository) {
        this.shortUrlsRepository = shortUrlsRepository;
    }

    public ShortUrls saveShortUrl(String shortUrl) {
        ShortUrls shortUrls = ShortUrls.builder()
                .shortUrl(shortUrl)
                .build();
        return this.shortUrlsRepository.save(shortUrls);
    }

    public ShortUrls saveShortUrl(ShortUrls shortUrls) {
        return this.shortUrlsRepository.save(shortUrls);
    }

    public void findShortUrlByShortPath(String shortPath) {
        this.shortUrlsRepository.findByShortPath(shortPath);
    }
}
