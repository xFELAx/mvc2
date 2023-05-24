package com.example.mvc.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
public class MovieDTO {
    private Integer id;
    private String title;

    private LocalDate releaseDate;

    private BigDecimal price;

    private String genre;

    private String rating;

}
