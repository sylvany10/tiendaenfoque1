package com.spring_app.tiendaenfoque.Repositorio;

import com.spring_app.tiendaenfoque.Entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
}
