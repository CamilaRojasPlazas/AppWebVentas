
package com.example.producto.servicios;


import com.example.producto.dao.ProductoRepositorio;
import com.example.producto.modelo.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoServicio {
    
    @Autowired
    ProductoRepositorio productoRepositorio;
    
    public List <Producto> getListaProducto(){
        return productoRepositorio.findAll();
    }
    
    public Optional<Producto> getProductoId(int id){
        return productoRepositorio.findById(id);
    }
    
    public Optional<Producto> getProductoNombre(String nombre){
        return productoRepositorio.findByNombre(nombre);
    }
    
    public void crearProducto(Producto producto){
        productoRepositorio.save(producto);
    }
    
    public void borrarId(int id){        
        productoRepositorio.deleteById(id);    
    }
    
    public boolean existeById(int id){
        return productoRepositorio.existsById(id);
    }
    
    public boolean existeByNombre(String nombre){
        return productoRepositorio.existsByNombre(nombre);
    }
}
