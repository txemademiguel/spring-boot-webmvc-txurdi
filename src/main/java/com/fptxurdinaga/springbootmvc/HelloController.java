package com.fptxurdinaga.springbootmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "<html>" +
                "<p>Greetings from Spring Boot!</p>"+
                "<p><a href='/mvchola'>Ejemplos de MVC</a>"+
                "</html>";
    }

}
