package com.spring_app.tiendaenfoque.Controlador;

import com.spring_app.tiendaenfoque.Entidad.Cliente;
import com.spring_app.tiendaenfoque.Entidad.Producto;
import com.spring_app.tiendaenfoque.Entidad.Servicio;
import com.spring_app.tiendaenfoque.Servicio.ClienteServicio;
import com.spring_app.tiendaenfoque.Servicio.ServicioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/servicio")
public class ServicioControlador {

    @Autowired
    private ServicioServicio servicioServicio;
    @Autowired
    private ClienteServicio clienteServicio;

    //LISTAR
    @GetMapping("/lista")
    public String mostrarServicios(Model model){
        List<Servicio> servicios = servicioServicio.listarServicios();
        model.addAttribute("servicios", servicios);
        return "servicio/listaServicios";
    }
    //CREAR
    @GetMapping("/nuevo")
    public String formularioServicio(Model model){
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("clientes", clienteServicio.listarClientes());
        return "servicio/formularioServicios";
    }
   //GUARDAR
    @PostMapping("/guardarServicio")
    public String guardarServicio(@ModelAttribute("servicio") Servicio servicio,
                                  @RequestParam("clienteId")Long clienteId){
        Cliente cliente = clienteServicio.buscarPorId(clienteId);
        cliente.setServicio(servicio);
        servicio.setCliente(cliente);
        servicioServicio.guardarServicio(servicio);
        return "redirect:/servicio/lista";}



    //ACTUALIZAR
   @GetMapping("/editar/{idServicio}")
   public String editarServicio(@PathVariable Long idServicio, Model model){
       Optional<Servicio> servicioOpt = servicioServicio.buscarServicio(idServicio);
       if (servicioOpt.isPresent()) {
           model.addAttribute("servicio", servicioOpt.get());
           return "servicio/formularioServicios";
       }
       return "redirect:/servicio/lista";
   }
    //ELIMINAR
    @GetMapping("/eliminar/{idServicio}")
    public String eliminarServicio(@PathVariable Long idServicio){
        servicioServicio.eliminarServicio(idServicio);
        return "redirect:/servicio/lista";
    }

}