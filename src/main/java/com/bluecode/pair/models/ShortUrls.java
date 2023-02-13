package com.bluecode.pair.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ShortUrls {

    @Id
    @GeneratedValue
    private Long id;

    private String shortUrl;

    private Integer hitCounter;

    public void increaseCounter() {
        this.hitCounter += 1;
    }

}