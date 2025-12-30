package com.spring_app.tiendaenfoque.Servicio;

import com.spring_app.tiendaenfoque.Entidad.Cliente;
import com.spring_app.tiendaenfoque.Entidad.Servicio;
import com.spring_app.tiendaenfoque.Repositorio.ClienteRepositorio;
import com.spring_app.tiendaenfoque.Repositorio.ServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServicio {

    @Autowired
    ServicioRepositorio servicioRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Servicio> listarServicios(){
        return servicioRepositorio.findAll();
    }
    public Optional<Servicio> buscarServicio(Long id){
        return servicioRepositorio.findById(id);
    }
    public void guardarServicio(Servicio servicio){
        servicioRepositorio.save(servicio);
    }
    public void eliminarServicio(Long id){
        servicioRepositorio.deleteById(id);
    }
    public Servicio buscarServicioByClienteId(Long clienteId){
        return clienteRepositorio.findById(clienteId)
                .map(Cliente::getServicio)
                .orElse(null);
    }
}
