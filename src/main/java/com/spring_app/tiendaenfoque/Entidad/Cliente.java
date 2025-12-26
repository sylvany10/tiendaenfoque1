package com.spring_app.tiendaenfoque.Entidad;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "tabla_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true, nullable = false)
    private String ruc;

    @Column (unique = true, nullable = false)
    private String nombre;

    private String telefono;





}
