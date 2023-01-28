
package com.example.producto.servicios;

import com.example.producto.dao.ProveedorRepositorio;
import com.example.producto.modelo.Proveedor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProveedorServicio {
    
    @Autowired
    ProveedorRepositorio proveedorRepositorio;
    
    public List <Proveedor> getListaProveedor(){
        return proveedorRepositorio.listaProveeor();
    }
    
    public Optional<Proveedor> getProveedorId(int id){
        return proveedorRepositorio.findById(id);
    }
    
    public Optional<Proveedor> getProveedorNit(String nit){
        return proveedorRepositorio.findByNit(nit);
    }
    
    public void crearProveedor(Proveedor proveedor){
        proveedorRepositorio.save(proveedor);
    }
    
    public boolean existeById(int id){
        return proveedorRepositorio.existsById(id);
    }
    
}
