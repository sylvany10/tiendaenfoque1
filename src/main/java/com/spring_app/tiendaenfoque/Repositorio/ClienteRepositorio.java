package com.spring_app.tiendaenfoque.Repositorio;

import com.spring_app.tiendaenfoque.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
