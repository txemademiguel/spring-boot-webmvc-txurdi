package com.fptxurdinaga.springbootmvc.domain;

import javax.validation.constraints.Size;

public class Usuario {

    @Size(min = 3, max = 20, message = "el nombre de usuario debe tener mas de 3 letras y menos de 20.")
    private String usuario;
    @Size(min = 3, max = 20, message = "la password debe tener mas de 3 letras")
    private String password;

    public Usuario() {
        super();
        this.usuario = "";
        this.password = "";
    }
    public Usuario(String usuario, String password) {
        super();
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
