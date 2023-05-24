package com.example.mvc.service;

import com.example.mvc.model.dto.MovieDTO;
import com.example.mvc.model.entity.Movie;
import com.example.mvc.model.mapper.MovieMapper;
import com.example.mvc.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<String> getGenres() {
        return  movieRepository.findDistinctGenres();
    }

    public List<MovieDTO> getMovies(String movieGenre, String searchString) {
        List<Movie> movies = null;
        if (searchString != null && !searchString.isEmpty()) {
            movies = movieRepository.findByTitleContaining(searchString);
        } else if (movieGenre != null && !movieGenre.isEmpty()) {
            movies = movieRepository.findByGenre(movieGenre);
        } else {
            movies = movieRepository.findAll();
        }
        return MovieMapper.mapListEntityToDTO(movies);
    }

    public MovieDTO getMovie(int id) {
         Movie entity = movieRepository.findById(id).orElse(null);
         return MovieMapper.mapEntityToDTO(entity);
    }
    @Transactional
    public MovieDTO createMovie(MovieDTO movie) {
        Movie newMovie = Movie.builder()
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .price(movie.getPrice())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .build();
        newMovie = movieRepository.save(newMovie);
        return MovieMapper.mapEntityToDTO(newMovie);
    }

    @Transactional
    public MovieDTO updateMovie(MovieDTO movie) {
        Movie newMovie = Movie.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .price(movie.getPrice())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .build();
        newMovie= movieRepository.save(newMovie);
        return MovieMapper.mapEntityToDTO(newMovie);
    }
    @Transactional
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}
