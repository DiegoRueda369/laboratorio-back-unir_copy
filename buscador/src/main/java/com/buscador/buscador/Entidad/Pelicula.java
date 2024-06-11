package com.buscador.buscador.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_pelicula")
public class Pelicula {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "backdrop_path")
    private String backdropPath;

    @Column(name = "poster_path", columnDefinition = "char")
    private String posterPath;

    @Column(name = "budget")
    private BigDecimal budget;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "popularity")
    private BigDecimal popularity;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "revenue")
    private BigDecimal revenue;

    @Column(name = "runtime")
    private Integer runtime;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "vote_average")
    private BigDecimal voteAverage;

    @Column(name = "vote_count")
    private BigDecimal voteCount;

    @Column(name = "overview")
    private String overview;

}
