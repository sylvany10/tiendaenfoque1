package com.spring_app.tiendaenfoque.Entidad;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "tabla_proveedor")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;
    private Double precio;
    private Integer cantidad;

}
