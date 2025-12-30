package com.spring_app.tiendaenfoque.Servicio;

import com.spring_app.tiendaenfoque.Entidad.Producto;
import com.spring_app.tiendaenfoque.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }

    public List<Producto> buscarProductoNombre(String buscarProducto){
        if(buscarProducto==null || buscarProducto.isEmpty()){
            return productoRepositorio.findAll();
        }else {
            return productoRepositorio.findByNombreContainingIgnoreCase(buscarProducto);
        }
    }
    public Optional<Producto> buscarProducto(Long id){
        return productoRepositorio.findById(id);
    }

    public void guardarProducto(Producto producto){
        productoRepositorio.save(producto);
    }

    public void eliminarProducto(Long id){
        productoRepositorio.deleteById(id);
    }
}
