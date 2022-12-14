
package com.example.producto.servicios;

import com.example.producto.dao.UsuarioRepositorio;
import com.example.producto.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServicio {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    public List <Usuario> getListaUsuario(){
        return usuarioRepositorio.findAll();
    }
    
    public Optional<Usuario> getUsuarioId(int id){
        return usuarioRepositorio.findById(id);
    }
    
    public Optional<Usuario> getUsuarioNombre(String nombre){
        return usuarioRepositorio.findByNombre(nombre);
    }
    
    public Optional<Usuario> getUsuarioCedula(String cedula){
        return usuarioRepositorio.findByCedula(cedula);
    }
    
    public Optional<Usuario> getUsuarioEmail(String email){
        return usuarioRepositorio.findByEmail(email);
    }
    
    public void crearUsuario(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }
    
    public void borrarUsuario(int id){
        usuarioRepositorio.deleteById(id);
    }
    
    public boolean existByEmail(String email){
        return usuarioRepositorio.existsByEmail(email);
    }
    
    
}
