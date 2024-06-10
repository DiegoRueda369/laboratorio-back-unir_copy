package com.buscador.buscador.Entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_cast")
public class Cast {

    @EmbeddedId
    private CastId id;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "popularity")
    private BigDecimal popularity;

    @Column(name = "profile_path")
    private String profilePath;

    @Column(name = "character")
    private String character;
}
