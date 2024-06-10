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
public class PaisRodajeId implements Serializable {

    @Column(name = "id_film")
    private Integer idFilm;

    @Column(name = "pais")
    private String pais;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaisRodajeId that = (PaisRodajeId) o;
        return Objects.equals(idFilm, that.idFilm) && Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, pais);
    }
}
