package com.fptxurdinaga.springbootmvc.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/mvchola")
public class MVCHola {
    // recibido via application.properties
    @Value("${hola.message}")
    private String message;
    private final List<String> lstElementos = Arrays.asList("Elemento1", "Elemento2", "Elemento3", "Elemento4");

    @GetMapping()
    public String main(Model model) {
        String cadena = "Valor Cadena";
        model.addAttribute("cadena", cadena);
        model.addAttribute("message", message);
        model.addAttribute("lstElementos", lstElementos);
        //view template hola.html
        return "hola"; 
    }

    @GetMapping("/parametros/{id}")
    public String getParametros(@PathVariable("id") String id, Model model){
        model.addAttribute("id",id);
        return "parametros";
    }
    @GetMapping("/parametros/{id}/{otro}")
    public String get2parametros(@PathVariable("id") String id,@PathVariable("otro") String otro, Model model){
        model.addAttribute("id",id);
        model.addAttribute("otro",otro);
        return "parametros2";
    }
   
    @PostMapping("/parametros")
    public String miPost(Model model, @RequestParam("id") String id){
        model.addAttribute("id",id);
        return "parametros";
    }
}
