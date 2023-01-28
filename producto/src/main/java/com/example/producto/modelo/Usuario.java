
package com.example.producto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// se vaya autoincrementando el id    
    private int id;
    private String nombre;
    private String cedula;
    private String email;
    private String contrasena; 
    private int rol;
    private boolean eliminado;

    public Usuario() {
    }

    public Usuario(String nombre, String cedula, String email, String contrasena, int rol, boolean eliminado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
        this.eliminado=eliminado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    } 

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    

    
}
