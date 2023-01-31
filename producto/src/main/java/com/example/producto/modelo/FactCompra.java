
package com.example.producto.modelo;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ASUS
 */
@Entity
public class FactCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// se vaya autoincrementando el id      
    private int id;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha;
    
    @ManyToOne()
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;
    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;  

    private int cantidad; 
    private double total;

    public FactCompra() {
    }

    public FactCompra(Date fecha, Proveedor proveedor, Producto producto, int cantidad, double total) {
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }    
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
    
}
