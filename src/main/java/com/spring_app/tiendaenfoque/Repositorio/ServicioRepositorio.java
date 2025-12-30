package com.spring_app.tiendaenfoque.Repositorio;

import com.spring_app.tiendaenfoque.Entidad.Producto;
import com.spring_app.tiendaenfoque.Entidad.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {

}
