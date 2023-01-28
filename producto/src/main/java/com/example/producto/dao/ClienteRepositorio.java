
package com.example.producto.dao;

import com.example.producto.modelo.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    
    Optional<Cliente> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
    Optional<Cliente>  findByEmail(String email);
    boolean existsByEmail(String email);
    
    Optional<Cliente> findByCedula(String cedula);
    boolean existsByCedula(String cedula); 
    
    @Query(value = "SELECT * FROM cliente WHERE eliminado=false;", nativeQuery=true)
    List<Cliente> listaClientes();
    
}
