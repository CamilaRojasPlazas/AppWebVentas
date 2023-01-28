
package com.example.producto.dto;

import javax.persistence.Column;


public class ClienteDto {
    
    private String nombre;

    @Column(unique=true)
    private String cedula;

    @Column(unique=true)
    private String email;
    
    private String telefono;
    
    private boolean eliminado;

    public ClienteDto() {
    }

    public ClienteDto(String nombre, String cedula, String email, String telefono ,boolean eliminado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.telefono=telefono;
        this.eliminado = eliminado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }  
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }    
    
    
}
