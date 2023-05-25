package com.example.mvc.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.mvc.model.entity.Movie;
import com.example.mvc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        // Look for any movies.
        if (movieRepository.count() > 0) {
            return;   // DB has been seeded
        }
        movieRepository.saveAll(
                List.of(
                        new Movie(1, "When Harry Met Sally", LocalDate.parse("1989-2-12"), BigDecimal.valueOf(7.99),"Romantic Comedy", "R"),
                        new Movie(2, "Ghostbusters", LocalDate.parse("1984-3-13"),BigDecimal.valueOf(8.99), "Comedy", "PG"),
                        new Movie(3, "Ghostbusters 2", LocalDate.parse("1986-2-23"),BigDecimal.valueOf(9.99), "Comedy", "PG"),
                        new Movie(4, "Rio Bravo", LocalDate.parse("1959-4-15"), BigDecimal.valueOf(3.99),"Western", "NR")
                )
        );
    }
}
