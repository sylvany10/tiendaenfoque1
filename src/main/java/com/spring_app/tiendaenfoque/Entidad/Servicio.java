package com.spring_app.tiendaenfoque.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descripcion;

    private Double precio;

    private int cantidad;

    @OneToOne(mappedBy = "servicio")
    @ToString.Exclude
    private Cliente cliente;

}
