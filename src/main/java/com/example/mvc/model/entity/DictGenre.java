package com.example.mvc.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DICT_GENRE")
@Data
public class DictGenre {
    @Id
    private String genre;
}
