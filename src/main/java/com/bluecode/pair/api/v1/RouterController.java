package com.bluecode.pair.api.v1;

import com.bluecode.pair.api.v1.resources.ShortUrlsResource;
import com.bluecode.pair.mappers.ShortUlrsMapper;
import com.bluecode.pair.models.ShortUrls;
import com.bluecode.pair.services.ShortUrlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RouterController {

    private ShortUrlsService shortUrlsService;
    private ShortUlrsMapper shortUlrsMapper;

    @Autowired
    public RouterController(ShortUrlsService shortUrlsService, ShortUlrsMapper shortUlrsMapper) {
        this.shortUrlsService = shortUrlsService;
        this.shortUlrsMapper = shortUlrsMapper;
    }

    @PostMapping("/{longPath}")
    public ShortUrlsResource retirectTest(@PathVariable String longPath) {
        String shortPath = this.converterClass.digest(longPath);
        Optional<ShortUrls> shortUrlsOptional = this.shortUrlsService.findShortUrlByShortPath(shortPath);
        ShortUrls shortUrls = new ShortUrls();
        if(shortUrlsOptional.isPresent()) {
            shortUrls = shortUrlsOptional.get();
            shortUrls.increaseCounter();
            this.shortUrlsService.saveShortUrl(shortUrls);
        } else {
            shortUrls = this.shortUrlsService.saveShortUrl(shortPath);
        }
        return this.shortUlrsMapper.shortUrlsToShortUrlsResource(shortUrls);
    }

    @GetMapping("/long/{shortPath}")
    public LongUrlsResource retirectTest(@PathVariable String shortUrl) {
        this.shortUrlsService.findShortUrlByShortPath(shortPath);
        String shortPath = this.converterClass.undigest(path);
        ShortUrls shortUrls = this.shortUrlsService.saveShortUrl(shortPath);
        String path = this.converterClass.undigest(shortPath);
    }
}
