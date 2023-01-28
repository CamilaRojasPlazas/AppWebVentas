
package com.example.producto.servicios;

import com.example.producto.dao.ClienteRepositorio;
import com.example.producto.modelo.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteServicio {
    
    @Autowired
    ClienteRepositorio clienteRepositorio;
    
    public List <Cliente> getListaCliente(){
        return clienteRepositorio.listaClientes();
    }
    
    public Optional<Cliente> getClienteId(int id){
        return clienteRepositorio.findById(id);
    }
    
    public Optional<Cliente> getClienteNombre(String nombre){
        return clienteRepositorio.findByNombre(nombre);
    }
    
    public Optional<Cliente> getUsuarioCedula(String cedula){
        return clienteRepositorio.findByCedula(cedula);
    }
    
    public void crearCliente(Cliente cliente){
        clienteRepositorio.save(cliente);
    }
    
    public void borrarCliente(int id){
        clienteRepositorio.deleteById(id);
    }
    
    public boolean existeById(int id){
        return clienteRepositorio.existsById(id);
    }
    
    public boolean existByEmail(String email){
        return clienteRepositorio.existsByEmail(email);
    }
    
}
