package com.example.mvc.repository;

import com.example.mvc.model.entity.DictGenre;
import com.example.mvc.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<DictGenre, Integer> {
}
