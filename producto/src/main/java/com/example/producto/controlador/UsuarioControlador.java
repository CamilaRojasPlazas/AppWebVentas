
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
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path="/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    @GetMapping(path="/list")
    public ResponseEntity<List<Usuario>> lista(){
        
        List<Usuario> lista=usuarioServicio.getListaUsuario();   
        return new ResponseEntity<List<Usuario>>(lista,HttpStatus.OK);
    }
    
    @PostMapping(path="/create")
    public ResponseEntity<?> crearProducto(@RequestBody UsuarioDto usuarioDto){
        
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
        
        Usuario newUsuario=new Usuario(usuarioDto.getNombre(),usuarioDto.getCedula(),usuarioDto.getEmail(),usuarioDto.getContrasena(),usuarioDto.getRol());
        usuarioServicio.crearUsuario(newUsuario);
        return new ResponseEntity(new Mensaje("Usuario creado"),HttpStatus.OK);
    }
    
    /*Login usuario*/
    @PostMapping(path="/login")
    public ResponseEntity<?> usuarioLogin(@RequestBody UsuarioDto usuarioDto){
        
        Usuario user=usuarioServicio.getUsuarioEmail(usuarioDto.getEmail()).get();
        
        if(user.getContrasena().equals(usuarioDto.getContrasena())){
            return ResponseEntity.ok(user);
        }
        
        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }

    
    
}
