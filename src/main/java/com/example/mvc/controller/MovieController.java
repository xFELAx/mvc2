package com.example.mvc.controller;

import com.example.mvc.model.dto.MovieDTO;
import com.example.mvc.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) String movieGenre, @RequestParam(required = false) String searchString) {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("genres", service.getGenres());
        modelAndView.addObject("movies", service.getMovies(movieGenre, searchString));
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id) {
        MovieDTO movie = service.getMovie(id);
        if (movie == null) {
            return new ModelAndView("404");
        }
        return new ModelAndView("details", "movie", movie);
    }

    @GetMapping("/create")
    public ModelAndView create() {

        MovieDTO movie = MovieDTO.builder().build();
        return new ModelAndView("movie", "movie", movie);
    }

    @PostMapping("/create")
    public ModelAndView create(MovieDTO movie) {
        service.createMovie(movie);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        MovieDTO movie =service.getMovie(id);
        if (movie == null) {
            return new ModelAndView("404");
        }
        return new ModelAndView("edit", "movie", movie);
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, MovieDTO movie) {
        movie = service.getMovie(movie.getId());
        if (movie.getId() != id) {
            return new ModelAndView("404");
        }
        service.updateMovie(movie);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        MovieDTO  movie = service.getMovie(id);

        if (movie == null) {
            return new ModelAndView("404");
        }
        return new ModelAndView("delete", "movie", movie);
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteConfirmed(@PathVariable int id) {
        service.deleteMovie(id);
        return new ModelAndView("redirect:/");
    }
}
