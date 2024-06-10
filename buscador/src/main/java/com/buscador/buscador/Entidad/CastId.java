package com.buscador.buscador.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CastId implements Serializable {

    @Column(name = "id_film")
    private Integer idFilm;

    @Column(name = "cast_id")
    private Integer castId;

    @Column(name = "name")
    private String castName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastId castId1 = (CastId) o;
        return Objects.equals(idFilm, castId1.idFilm) && Objects.equals(castId, castId1.castId) && Objects.equals(castName, castId1.castName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, castId, castName);
    }
}
