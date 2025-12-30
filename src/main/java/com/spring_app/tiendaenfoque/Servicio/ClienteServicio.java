package com.spring_app.tiendaenfoque.Servicio;

import com.spring_app.tiendaenfoque.Entidad.Cliente;
import com.spring_app.tiendaenfoque.Entidad.Producto;
import com.spring_app.tiendaenfoque.Repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarClientes(){
         return clienteRepositorio.findAll();
    }
    public Optional<Cliente> buscarCliente(Long id){
        return clienteRepositorio.findById(id);
    }
    public void guardarCliente(Cliente cliente){
        clienteRepositorio.save(cliente);
    }
    public void eliminarCliente(Long id){
        clienteRepositorio.deleteById(id);
    }
    public List<Producto> buscarProductoByClienteId(Long clienteId){
        return clienteRepositorio.findById(clienteId)
                .map(Cliente::obtenerProductos)
                .orElse(List.of());
    }
    public Cliente buscarPorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

}
