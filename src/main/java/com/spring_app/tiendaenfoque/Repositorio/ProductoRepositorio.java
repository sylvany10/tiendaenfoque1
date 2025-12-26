package com.spring_app.tiendaenfoque.Repositorio;


import com.spring_app.tiendaenfoque.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {



}
