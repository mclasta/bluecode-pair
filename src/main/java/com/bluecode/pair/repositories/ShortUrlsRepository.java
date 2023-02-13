package com.bluecode.pair.repositories;

import com.bluecode.pair.models.ShortUrls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlsRepository extends JpaRepository<ShortUrls, Long> {

    ShortUrls findByShortPath(String shortUrls);
}
