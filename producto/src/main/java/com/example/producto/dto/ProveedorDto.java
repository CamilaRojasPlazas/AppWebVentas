
package com.example.producto.dto;

import javax.persistence.Column;


public class ProveedorDto {
    
    private String nombre;

    @Column(unique=true)
    private String nit;

    @Column(unique=true)
    private String email;

    private String telefono;
    private boolean eliminado;
    

    public ProveedorDto() {
    }

    public ProveedorDto(String nombre, String nit, String email, String telefono, boolean eliminado) {
        this.nombre = nombre;
        this.nit = nit;
        this.email = email;
        this.telefono = telefono;
        this.eliminado = eliminado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    
}
