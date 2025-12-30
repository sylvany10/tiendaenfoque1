package com.spring_app.tiendaenfoque.Controlador;

import com.spring_app.tiendaenfoque.Entidad.Cliente;
import com.spring_app.tiendaenfoque.Entidad.Producto;
import com.spring_app.tiendaenfoque.Servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    //LISTAR
    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteServicio.listarClientes();
        model.addAttribute("clientes", clientes);
        return "Cliente/listaClientes";
    }

    // CREAR
    @GetMapping("/formularioCliente")
    public String formularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Cliente/formularioClientes";
    }
    //GUARDAR
    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteServicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    // ACTUALIZAR
    @GetMapping("/editarCliente/{idCliente}")
    public String editarCliente(@PathVariable Long idCliente, Model model) {
        Optional<Cliente> cliente = clienteServicio.buscarCliente(idCliente);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "Cliente/formularioClientes";
        }
        return "redirect:/clientes";
    }

    // ELIMINAR
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(@PathVariable Long idCliente) {
        clienteServicio.eliminarCliente(idCliente);
        return "redirect:/clientes";
    }


}
