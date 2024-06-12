package com.Operador.operador.Entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "t_usuario")
@Getter
@Setter

public class Usuario {
    @Id
    @Column(name = "tu_userid")
    private String tuUserid;
    @Column(name = "tu_mail")
    private String tuMail;
    @Column(name = "tu_uname")
    private String tuUname;
    @Column(name = "tu_upass")
    private String tuUpass;
    @Column(name = "tu_telefono")
    private String tuTelefono;
    @Column(name = "tu_direccion")
    private String tuDireccion;

    @OneToMany(mappedBy = "usuario")
    private Set<Transaccion> transacciones;

}

