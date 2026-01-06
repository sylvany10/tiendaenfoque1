package com.spring_app.tiendaenfoque.Controlador;

import com.spring_app.tiendaenfoque.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/registrar")
    public String formularioUsuario(){
        return "Usuario/registroUsuario";
    }
    @PostMapping("/registro")
    public String registrarUsuario(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam String password, Model model){
        try{
            usuarioServicio.registrarUsuario(nombre, email, password);
            model.addAttribute("exito", "Usuario registrado con éxito");
            return "index";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "Usuario/registroUsuario";
        }
    }
    @GetMapping("/login")
    public String login(){
        return "Usuario/login";
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicioSesion(){
        return "Usuario/inicioSesion";
    }
}
