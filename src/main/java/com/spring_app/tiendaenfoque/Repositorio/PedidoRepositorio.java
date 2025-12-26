package com.spring_app.tiendaenfoque.Repositorio;

import com.spring_app.tiendaenfoque.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {


}
