
package com.example.producto.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class UsuarioDto {
    

    private String nombre;

    @Column(unique=true)
    private String cedula;

    @Column(unique=true)
    private String email;

    private String contrasena;

    private int rol;

    public UsuarioDto() {
    }

    public UsuarioDto( String nombre, String cedula, String email, String contrasena, int rol) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
   
}
