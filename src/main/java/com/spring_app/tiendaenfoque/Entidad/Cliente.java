package com.spring_app.tiendaenfoque.Entidad;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String identificacionC;
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String telefonoCliente;

    //relación servicio cliente
    @OneToOne
    @JoinColumn(name = "servicio_id")
    @ToString.Exclude
    private Servicio servicio;

    // relación producto cliente
    @ManyToMany
    @JoinTable(name = "producto_cliente",
    joinColumns = @JoinColumn(name = "cliente_id"),
    inverseJoinColumns = @JoinColumn(name = "producto_id"))

    private List<Producto> productos;

    public List<Producto> obtenerProductos(){
        return productos;
    }



}
