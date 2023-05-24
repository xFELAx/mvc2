package com.example.mvc.model.mapper;

import com.example.mvc.model.dto.MovieDTO;
import com.example.mvc.model.entity.Movie;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class MovieMapper {
    public static MovieDTO  mapEntityToDTO(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .releaseDate(movie.getReleaseDate())
                .price(movie.getPrice())
                .genre(movie.getGenre())
                .rating(movie.getRating())
                .build();
    }

    public static Movie mapDTOToEntity(MovieDTO movieDTO) {
        return Movie.builder()
                .id(movieDTO.getId())
                .title(movieDTO.getTitle())
                .releaseDate(movieDTO.getReleaseDate())
                .price(movieDTO.getPrice())
                .genre(movieDTO.getGenre())
                .rating(movieDTO.getRating())
                .build();
    }
    public static List<Movie> mapListDTOToEntity(List<MovieDTO> movieDTOList) {
        return movieDTOList.stream().map(MovieMapper::mapDTOToEntity).collect(Collectors.toList());
    }

    public static List<MovieDTO> mapListEntityToDTO(List<Movie> movieList) {
        return movieList.stream().map(MovieMapper::mapEntityToDTO).collect(Collectors.toList());
    }
}
