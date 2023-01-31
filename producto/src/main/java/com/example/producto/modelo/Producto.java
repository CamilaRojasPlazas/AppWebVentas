
package com.example.producto.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Producto{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// se vaya autoincrementando el id    
    private int id;
    private String codigo;
    private String nombre;
    private float precio;
    private int stock;
    
    @OneToMany(mappedBy = "producto")    
    private List<FactCompra> facturasCompras;

    public Producto() {
    }

    public Producto(String codigo, String nombre, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getStock() {
        return stock;
    }   
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }   

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }   

}
