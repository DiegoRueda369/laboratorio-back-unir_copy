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
public class ProduccionId implements Serializable {

    @Column(name = "id_film")
    private Integer idFilm;

    @Column(name = "id")
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduccionId produccionId = (ProduccionId) o;
        return Objects.equals(idFilm, produccionId.idFilm) && Objects.equals(id, produccionId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, id);
    }
}
