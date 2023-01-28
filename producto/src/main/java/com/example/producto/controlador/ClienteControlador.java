
package com.example.producto.controlador;

import com.example.producto.dto.ClienteDto;
import com.example.producto.dto.Mensaje;
import com.example.producto.modelo.Cliente;
import com.example.producto.servicios.ClienteServicio;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControlador {
    
    @Autowired
    ClienteServicio clienteServicio;
    
    /*-------------------------METODOS PROPIOS DE LOS USUARIO -----------------------------------*/
    @GetMapping(path="/list")
    public ResponseEntity<List<Cliente>> lista(){
        
        List<Cliente> lista=clienteServicio.getListaCliente();   
        return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
    }
    
    @PostMapping(path="/create")
    public ResponseEntity<?> crearCliente(@RequestBody ClienteDto clienteDto){
        
        if(StringUtils.isBlank(clienteDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(clienteDto.getCedula())){
            return new ResponseEntity(new Mensaje("La cedula es obligatoria"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(clienteDto.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(clienteDto.getTelefono())){
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Cliente newCliente=new Cliente(clienteDto.getNombre(),clienteDto.getCedula(),clienteDto.getEmail(),clienteDto.getTelefono(),false);
        clienteServicio.crearCliente(newCliente);
        return new ResponseEntity(new Mensaje("Cliente creado"),HttpStatus.OK);
    }
    
    @GetMapping(path="/detail/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") int id){
        if(!clienteServicio.existeById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        
        Cliente usuario=clienteServicio.getClienteId(id).get();        
        return new ResponseEntity(usuario,HttpStatus.OK);
    }
    
    @PutMapping(path="/update/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable("id") int id,@RequestBody ClienteDto clienteDto){
        
        if(StringUtils.isBlank(clienteDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(clienteDto.getCedula())){
            return new ResponseEntity(new Mensaje("La cedula es obligatoria"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(clienteDto.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(clienteDto.getTelefono())){
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        
        Cliente newUsuario=clienteServicio.getClienteId(id).get(); 
        newUsuario.setNombre(clienteDto.getNombre());
        newUsuario.setCedula(clienteDto.getCedula());
        newUsuario.setEmail(clienteDto.getEmail());
        newUsuario.setTelefono(clienteDto.getTelefono());
        newUsuario.setEliminado(clienteDto.getEliminado());
        clienteServicio.crearCliente(newUsuario);
        return new ResponseEntity(new Mensaje("Cliente actualizado"),HttpStatus.OK);
    }
    
    @DeleteMapping(path="/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") int id){

        Cliente usuario=clienteServicio.getClienteId(id).get(); 
        usuario.setNombre(usuario.getNombre());
        usuario.setCedula(usuario.getCedula());
        usuario.setEmail(usuario.getEmail());
        usuario.setTelefono(usuario.getTelefono());
        usuario.setEliminado(true);
        clienteServicio.crearCliente(usuario);
        return new ResponseEntity(new Mensaje("Cliente eliminado"),HttpStatus.OK);
    }
    
}
