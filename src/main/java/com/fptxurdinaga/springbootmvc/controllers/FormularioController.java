package com.fptxurdinaga.springbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Persona;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/formulario")
public class FormularioController {
    @GetMapping()
    public String lista(Model modelo) {

        Persona persona= new Persona(0L,"CIFP","Txurdi",50);

        modelo.addAttribute("persona", persona);
        return "formulario";

    }
    /*
    @PostMapping("/create")
    public ModelAndView createUser(@Valid Persona persona, BindingResult result) {
        ModelAndView model = new ModelAndView();
        model.addObject("persona", persona);
        model.setViewName(result.hasErrors() ? "form" : "personaReady");
        return model;
    }
    */
    @PostMapping("/create")
    public String createUser(@Valid Persona persona, BindingResult result, Model model) {
        model.addAttribute("persona", persona);
        String template ="";
        if(result.hasErrors()) {
        	// si hay errores vuelvo a la plantilla formulario
        	template ="formulario";
        }
        else {
        	// si NO hay errores voy a la plantilla personaReady
        	template ="personaReady";
        }
        return template;
    }
}
