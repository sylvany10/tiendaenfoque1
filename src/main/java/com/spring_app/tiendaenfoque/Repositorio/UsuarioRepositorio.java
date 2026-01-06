package com.spring_app.tiendaenfoque.Repositorio;

import com.spring_app.tiendaenfoque.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email= :email")
    public Usuario buscarUsuarioByEmail(@Param("email")String email);

}
