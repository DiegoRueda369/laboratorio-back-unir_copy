package com.buscador.buscador.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "t_genero")
public class Genero {

    @EmbeddedId
    private GeneroId id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_film", insertable = false, updatable = false)
    @JsonIgnore
    private Pelicula pelicula;
}
