package com.example.producto.dao;


import com.example.producto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    
    Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre); 
    
}

