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
public class GeneroId implements Serializable {

    @Column(name = "id_film")
    private Integer idFilm;

    @Column(name = "id")
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneroId generoId = (GeneroId) o;
        return Objects.equals(idFilm, generoId.idFilm) && Objects.equals(id, generoId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, id);
    }
}
