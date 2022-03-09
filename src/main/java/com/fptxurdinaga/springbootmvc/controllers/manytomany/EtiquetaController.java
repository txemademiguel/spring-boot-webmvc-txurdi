package com.fptxurdinaga.springbootmvc.controllers.manytomany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fptxurdinaga.springbootmvc.domain.manytomany.Etiqueta;
import com.fptxurdinaga.springbootmvc.domain.manytomany.Noticia;
import com.fptxurdinaga.springbootmvc.repositories.manytomany.EtiquetaRepository;
import com.fptxurdinaga.springbootmvc.repositories.manytomany.NoticiaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

@Controller
@RequestMapping(value = "/etiquetas")
public class EtiquetaController {
    Logger logger = LoggerFactory.getLogger(EtiquetaController.class);
    @Autowired
    private EtiquetaRepository etiquetaRepository;
    @Autowired
    private NoticiaRepository noticiaRepository;
    @GetMapping()
    public String lista(Model modelo) {
        List<Etiqueta> etiquetas = etiquetaRepository.findAll();
        modelo.addAttribute("etiquetas", etiquetas);
        return "etiquetas/listado";

    }
    @GetMapping("/insert")
    public String insert(Model modelo) {
        Integer actualSize= etiquetaRepository.findAll().size();
        logger.trace("/mvchola/insert: actualSize="+actualSize);
        if ( actualSize.equals(0)){
            Etiqueta etiqueta = new Etiqueta();
            etiqueta.setNombre("Internacional");
            Noticia noticia = new Noticia();
            noticia.setTitular("Rusia ataca Ucrania");
            etiqueta.getNoticias().add(noticia);
            etiquetaRepository.save(etiqueta);
            System.out.println("/mvchola/insert: etiqueta="+etiqueta);
        }
        List<Etiqueta>  listado = etiquetaRepository.findAll();
        modelo.addAttribute("etiquetas", listado);
        return "etiquetas/listado";

    }

    @GetMapping("/show/{id}")
    public String insert(Model modelo, @PathVariable("id") Long id) {
        Etiqueta etiqueta = this.etiquetaRepository.getById(id);
        modelo.addAttribute("etiqueta", etiqueta);

        return "etiquetas/show";

    }

    @GetMapping("/update/{id}")
    public String udpate(Model modelo, @PathVariable("id") Long id) {
        Optional <Etiqueta> etiqueta = this.etiquetaRepository.findById(id);
        if (etiqueta.isPresent()){
            Etiqueta etiquetaRegistry = etiqueta.get();
            logger.trace(etiquetaRegistry.toString());
            etiquetaRegistry.setNombre("Economía");
            etiquetaRegistry.getNoticias().get(0).setTitular("Aprobado el Ingreso Mínimo Vital");
            etiquetaRepository.save(etiquetaRegistry);
            modelo.addAttribute("etiqueta", etiquetaRegistry);
        }else{
            modelo.addAttribute("etiqueta", new Etiqueta());
        }
        return "etiquetas/show";

    }

    @GetMapping("/delete/{id}")
    public String delete(Model modelo, @PathVariable("id") Long id) {
        Optional<Etiqueta> etiqueta = this.etiquetaRepository.findById(id);

        if (etiqueta.isPresent()){
            Etiqueta etiquetaRegistry = etiqueta.get();
            logger.trace(etiquetaRegistry.toString());
            etiquetaRepository.delete(etiquetaRegistry);
            modelo.addAttribute("etiqueta", etiquetaRegistry);
        }else{
            modelo.addAttribute("etiqueta", new Etiqueta());
        }

        return "etiquetas/show";

    }

}
