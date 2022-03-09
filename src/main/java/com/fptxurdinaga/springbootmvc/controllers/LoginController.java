package com.fptxurdinaga.springbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fptxurdinaga.springbootmvc.domain.Usuario;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    
	@GetMapping()
    public String lista(Model modelo) {
        Usuario usuario= new Usuario("admin","admin");
        modelo.addAttribute("usuario", usuario);
        return "login";
    }
    
	@PostMapping("/logincomprobar")
    public String createUser(@Valid Usuario usuario, BindingResult result, Model model) {
        model.addAttribute("usuario", usuario);
        String template ="login";
        if(result.hasErrors()) {
        	// si hay errores vuelvo a la plantilla login
        	template ="login";
        }
        else if (usuario.getUsuario().equals("admin") && usuario.getPassword().equals("admin")) {
        	// si los datos son correctos voy la plantilla hola
        	model.addAttribute("message", usuario.getUsuario());
        	template ="hola";
        }
        return template;
    }
}
