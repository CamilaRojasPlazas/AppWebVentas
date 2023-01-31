
package com.example.producto.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// se vaya autoincrementando el id    
    private int id;
    private String nombre;
    private String nit;
    private String email;
    private String telefono; 
    private boolean eliminado;
    
    
    @OneToMany(mappedBy = "proveedor")    
    private List<FactCompra> facturasCompras;

    public Proveedor() {
    }

    public Proveedor(String nombre, String nit, String email, String telefono, boolean eliminado) {
        this.nombre = nombre;
        this.nit = nit;
        this.email = email;
        this.telefono = telefono;
        this.eliminado = eliminado;
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

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    

    
    
    
    
}
