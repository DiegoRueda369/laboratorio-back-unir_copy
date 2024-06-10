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
@Table(name = "t_produccion")
public class Produccion {

    @EmbeddedId
    private ProduccionId id;

    @Column(name = "logo_path")
    private String logoPath;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_film", insertable = false, updatable = false)
    private Pelicula pelicula;
}
