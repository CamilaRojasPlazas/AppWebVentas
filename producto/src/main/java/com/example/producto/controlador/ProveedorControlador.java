
package com.example.producto.controlador;

import com.example.producto.dto.Mensaje;
import com.example.producto.dto.ProveedorDto;
import com.example.producto.modelo.Proveedor;
import com.example.producto.servicios.ProveedorServicio;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path="/proveedor")
@CrossOrigin(origins = "http://localhost:4200")

public class ProveedorControlador {
    @Autowired
    ProveedorServicio proveedorServicio;
    
    /*-------------------------METODOS PROPIOS DE LOS USUARIO -----------------------------------*/
    @GetMapping(path="/list")
    public ResponseEntity<List<Proveedor>> lista(){
        
        List<Proveedor> lista=proveedorServicio.getListaProveedor();   
        return new ResponseEntity<List<Proveedor>>(lista,HttpStatus.OK);
    }
    
    @PostMapping(path="/create")
    public ResponseEntity<?> crearProveedor(@RequestBody ProveedorDto proveedorDto){
        
        if(StringUtils.isBlank(proveedorDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(proveedorDto.getNit())){
            return new ResponseEntity(new Mensaje("El NIT es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(proveedorDto.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(proveedorDto.getTelefono())){
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Proveedor newProveedor=new Proveedor(proveedorDto.getNombre(),proveedorDto.getNit(),proveedorDto.getEmail(),proveedorDto.getTelefono(),false);
        proveedorServicio.crearProveedor(newProveedor);
        return new ResponseEntity(new Mensaje("Proveedor creado"),HttpStatus.OK);
    }
    
    @GetMapping(path="/detail/{id}")
    public ResponseEntity<Proveedor> getById(@PathVariable("id") int id){
        if(!proveedorServicio.existeById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        
        Proveedor proveedor=proveedorServicio.getProveedorId(id).get();        
        return new ResponseEntity(proveedor,HttpStatus.OK);
    }
    
    @PutMapping(path="/update/{id}")
    public ResponseEntity<?> updateProveedor(@PathVariable("id") int id,@RequestBody ProveedorDto proveedorDto){
        
        if(StringUtils.isBlank(proveedorDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(proveedorDto.getNit())){
            return new ResponseEntity(new Mensaje("El NIT es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(proveedorDto.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(proveedorDto.getTelefono())){
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Proveedor newUsuario=proveedorServicio.getProveedorId(id).get(); 
        newUsuario.setNombre(proveedorDto.getNombre());
        newUsuario.setNit(proveedorDto.getNit());
        newUsuario.setEmail(proveedorDto.getEmail());
        newUsuario.setTelefono(proveedorDto.getTelefono());
        newUsuario.setEliminado(proveedorDto.getEliminado());
        proveedorServicio.crearProveedor(newUsuario);
        return new ResponseEntity(new Mensaje("Proveedor actualizado"),HttpStatus.OK);
    }
    
    @DeleteMapping(path="/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") int id){

        Proveedor proveedor=proveedorServicio.getProveedorId(id).get(); 
        proveedor.setNombre(proveedor.getNombre());
        proveedor.setNit(proveedor.getNit());
        proveedor.setEmail(proveedor.getEmail());
        proveedor.setTelefono(proveedor.getTelefono());
        proveedor.setEliminado(true);
        proveedorServicio.crearProveedor(proveedor);
        return new ResponseEntity(new Mensaje("Proveedor eliminado"),HttpStatus.OK);
    }
    
}
