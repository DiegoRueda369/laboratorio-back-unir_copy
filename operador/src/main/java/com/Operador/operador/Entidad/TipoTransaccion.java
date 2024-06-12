package com.Operador.operador.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_tipo_transaccion")
@Getter
@Setter

public class TipoTransaccion {
    @Id
    @Column(name = "ttr_id", columnDefinition = "char", length = 255)
    private String ttrId;
    @Column(name = "ttr_descripcion")
    private String ttrDescripcion;
}
