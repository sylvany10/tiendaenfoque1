package com.spring_app.tiendaenfoque.Entidad;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, nullable = false)
    private String nombre;

    private Double precio;

    private int stock;

    @ManyToMany(mappedBy = "productos")
    private List<Cliente> clientes;

}
