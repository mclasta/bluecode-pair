package com.bluecode.pair.mappers;

import com.bluecode.pair.api.v1.resources.ShortUrlsResource;
import com.bluecode.pair.models.ShortUrls;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "sprint")
public interface ShortUlrsMapper {

    ShortUrlsResource shortUrlsToShortUrlsResource(ShortUrls shortUrls);

    @InheritInverseConfiguration
    ShortUrls shortUrlsResourceToShortUrls(ShortUrlsResource shortUrlsResource);

}
