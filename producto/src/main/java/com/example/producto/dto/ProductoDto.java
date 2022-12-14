
package com.example.producto.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class ProductoDto {
    
  

    private String nombre;
    private String codigo;
    @Min(0)
    private Float precio;
 

    public ProductoDto() {
    }

    public ProductoDto(String codigo,String nombre, @Min(0) Float precio){
        this.codigo=codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }


    public String getNombre() {
        return nombre;
    }
    
    public Float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
}
