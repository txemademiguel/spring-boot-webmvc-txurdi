package com.fptxurdinaga.springbootmvc.controllers.onetomany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fptxurdinaga.springbootmvc.domain.onetomany.Autor;
import com.fptxurdinaga.springbootmvc.domain.onetomany.Libro;
import com.fptxurdinaga.springbootmvc.repositories.onetomany.AutorRepository;
import com.fptxurdinaga.springbootmvc.repositories.onetomany.LibroRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/autores")
public class AutorController {
    Logger logger = LoggerFactory.getLogger(AutorController.class);
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LibroRepository libroRepository;
    @GetMapping()
    public String lista(Model modelo) {
        List<Autor> autores = autorRepository.findAll();
        modelo.addAttribute("autores", autores);
        return "autores/listado";

    }

    @GetMapping("/insert")
    public String insert(Model modelo) {
        Integer actualSize= autorRepository.findAll().size();
        logger.trace("/mvchola/insert: actualSize="+actualSize);
        if ( actualSize.equals(0)){

            Autor autor = new Autor();
            autor.setNombre("Terry Pratchett");
            //autorRepository.save(autor);
            Libro libro = new Libro();
            libro.setTitle("El color de la magia");
            //libroRepository.save(libro);
            autor.getLibros().add(libro);
            autorRepository.save(autor);
            System.out.println("/mvchola/insert: autor="+autor);
        }
        List<Autor> listado = autorRepository.findAll();
        modelo.addAttribute("autores", listado);
        return "autores/listado";

    }

    @GetMapping("/show/{id}")
    public String insert(Model modelo, @PathVariable("id") Long id) {
        Optional<Autor> autor = this.autorRepository.findById(id);
        if (autor.isPresent()){
            Autor autorRegistry = autor.get();
            logger.trace(autorRegistry.toString());
            modelo.addAttribute("autor", autor.get());
        }else{
            modelo.addAttribute("autor", new Autor());
        }

        return "autores/show";

    }

    @GetMapping("/update/{id}")
    public String udpate(Model modelo, @PathVariable("id") Long id) {
        Optional<Autor> autor = this.autorRepository.findById(id);
        if (autor.isPresent()){
            Autor autorRegistry = autor.get();
            logger.trace(autorRegistry.toString());
            autorRegistry.setNombre("Neil Gayman");
            autorRegistry.getLibros().get(0).setTitle("Buenos Presagios");
            autorRepository.save(autorRegistry);
            modelo.addAttribute("autor", autorRegistry);
        }else{
            modelo.addAttribute("autor", new Autor());
        }
        return "autores/show";

    }

    @GetMapping("/delete/{id}")
    public String delete(Model modelo, @PathVariable("id") Long id) {
        Optional<Autor> autor = this.autorRepository.findById(id);

        if (autor.isPresent()){
            Autor autorRegistry = autor.get();
            logger.trace(autorRegistry.toString());
            autorRepository.delete(autorRegistry);
            modelo.addAttribute("autor", autorRegistry);
        }else{
            modelo.addAttribute("autor", new Autor());
        }

        return "autores/show";

    }



}
