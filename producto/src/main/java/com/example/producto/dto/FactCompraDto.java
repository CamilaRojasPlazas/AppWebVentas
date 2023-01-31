
package com.example.producto.dto;

import com.example.producto.modelo.Producto;
import com.example.producto.modelo.Proveedor;
import java.util.Date;
import javax.validation.constraints.NotBlank;


public class FactCompraDto {
    
    private Date fecha;    
    private Proveedor proveedor;
    private Producto producto;  
    private int cantidad;
    private double total;

    public FactCompraDto() {
    }

    public FactCompraDto(Date fecha, Proveedor proveedor, Producto producto, int cantidad, double total) {
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
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
    
    
    
}
