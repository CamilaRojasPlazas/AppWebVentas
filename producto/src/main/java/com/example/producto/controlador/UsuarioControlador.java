
package com.example.producto.controlador;

import com.example.producto.dto.UsuarioDto;
import com.example.producto.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import com.example.producto.dto.Mensaje;
import com.example.producto.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path="/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    
    /*-------------------------METODOS PROPIOS DE LOS USUARIO -----------------------------------*/
    @GetMapping(path="/list")
    public ResponseEntity<List<Usuario>> lista(){
        
        List<Usuario> lista=usuarioServicio.getListaUsuario();   
        return new ResponseEntity<List<Usuario>>(lista,HttpStatus.OK);
    }
    
    @PostMapping(path="/create")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDto usuarioDto){
        
        if(StringUtils.isBlank(usuarioDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(usuarioDto.getCedula())){
            return new ResponseEntity(new Mensaje("La cedula es obligatoria"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(usuarioDto.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(usuarioDto.getContrasena())){
            return new ResponseEntity(new Mensaje("La contraseña es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        
        Usuario newUsuario=new Usuario(usuarioDto.getNombre(),usuarioDto.getCedula(),usuarioDto.getEmail(),usuarioDto.getContrasena(),usuarioDto.getRol(),false);
        usuarioServicio.crearUsuario(newUsuario);
        return new ResponseEntity(new Mensaje("Usuario creado"),HttpStatus.OK);
    }
    
    @GetMapping(path="/detail/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") int id){
        if(!usuarioServicio.existeById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        
        Usuario usuario=usuarioServicio.getUsuarioId(id).get();        
        return new ResponseEntity(usuario,HttpStatus.OK);
    }
    
    
    @PutMapping(path="/update/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") int id,@RequestBody UsuarioDto usuarioDto){
        
        if(StringUtils.isBlank(usuarioDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(usuarioDto.getCedula())){
            return new ResponseEntity(new Mensaje("La cedula es obligatoria"),HttpStatus.BAD_REQUEST);
        }        
        if(StringUtils.isBlank(usuarioDto.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(usuarioDto.getContrasena())){
            return new ResponseEntity(new Mensaje("La contraseña es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        
        Usuario newUsuario=usuarioServicio.getUsuarioId(id).get(); 
        newUsuario.setNombre(usuarioDto.getNombre());
        newUsuario.setCedula(usuarioDto.getCedula());
        newUsuario.setEmail(usuarioDto.getEmail());
        newUsuario.setContrasena(usuarioDto.getContrasena());
        newUsuario.setRol(usuarioDto.getRol());
        newUsuario.setEliminado(usuarioDto.getEliminado());
        usuarioServicio.crearUsuario(newUsuario);
        return new ResponseEntity(new Mensaje("Usuario actualizado"),HttpStatus.OK);
    }
    
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> eliminarUsr(@PathVariable("id") int id){
        
        if(!usuarioServicio.existeById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        
       usuarioServicio.borrarUsuario(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"),HttpStatus.OK);     
    
    }
    
    @DeleteMapping(path="/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") int id){

        Usuario usuario=usuarioServicio.getUsuarioId(id).get(); 
        usuario.setNombre(usuario.getNombre());
        usuario.setCedula(usuario.getCedula());
        usuario.setEmail(usuario.getEmail());
        usuario.setContrasena(usuario.getContrasena());
        usuario.setRol(usuario.getRol());
        usuario.setEliminado(true);
        usuarioServicio.crearUsuario(usuario);
        return new ResponseEntity(new Mensaje("Usuario eliminado"),HttpStatus.OK);
    }
    
    
    

    /*-----------------------------------LOGIN USUARIO------------------------------------------*/
    @PostMapping(path="/login")
    public ResponseEntity<?> usuarioLogin(@RequestBody UsuarioDto usuarioDto){
        
        Usuario user=usuarioServicio.getUsuarioEmail(usuarioDto.getEmail()).get();
        
        if(user.getContrasena().equals(usuarioDto.getContrasena())){
            return ResponseEntity.ok(user);
        }
        
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }   
    
}
