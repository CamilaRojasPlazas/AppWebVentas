
package com.example.producto.dao;

import com.example.producto.modelo.Proveedor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {
    
    Optional<Proveedor> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
    Optional<Proveedor>  findByEmail(String email);
    boolean existsByEmail(String email);
    
    Optional<Proveedor> findByNit(String nit);
    boolean existsByNit(String nit); 
    
    @Query(value = "SELECT * FROM proveedor WHERE eliminado=false;", nativeQuery=true)
    List<Proveedor> listaProveeor();
    
}
