
package com.example.producto.dao;

import com.example.producto.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
    Optional<Usuario>  findByEmail(String email);
    boolean existsByEmail(String email);
    
    Optional<Usuario> findByCedula(String cedula);
    boolean existsByCedula(String cedula);  
    
    @Query(value = "SELECT * FROM usuario WHERE eliminado=false;", nativeQuery=true)
    List<Usuario> listaUsuarios();
    
    
}
