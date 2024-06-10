package com.buscador.buscador.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_pais_rodaje")
public class PaisRodaje {

    @EmbeddedId
    private PaisRodajeId id;

    @ManyToOne
    @JoinColumn(name = "id_film", insertable = false, updatable = false)
    private Pelicula pelicula;
}
