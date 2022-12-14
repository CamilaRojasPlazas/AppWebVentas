
package com.example.producto.controlador;


import com.example.producto.dto.Mensaje;
import com.example.producto.dto.ProductoDto;
import com.example.producto.modelo.Producto;
import com.example.producto.servicios.ProductoServicio;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping(path="/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControlador {
    
    //creo un objeto de productoServicio
    @Autowired
    ProductoServicio productoServicio;
    
    @GetMapping(path="/list")
    public ResponseEntity<List<Producto>> lista(){
        
        List<Producto> lista=productoServicio.getListaProducto();   
        return new ResponseEntity(lista,HttpStatus.OK);
    }    
    
    @GetMapping(path="/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
        if(!productoServicio.existeById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        
        Producto producto=productoServicio.getProductoId(id).get();        
        return new ResponseEntity(producto,HttpStatus.OK);
    }
    
    
    @GetMapping(path="/detailname/{nombre}")
    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre){
        if(!productoServicio.existeByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        
        Producto producto=productoServicio.getProductoNombre(nombre).get();        
        return new ResponseEntity(producto,HttpStatus.OK);
    }
    
    
    @PostMapping(path="/create")
    public ResponseEntity<?> crearProducto(@RequestBody ProductoDto productoDto){
        
        if(StringUtils.isBlank(productoDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(productoDto.getCodigo())) {
            return new ResponseEntity(new Mensaje("El codigo es obligatorio"),HttpStatus.BAD_REQUEST);
        } 
        if(productoDto.getPrecio()<0 || productoDto.getPrecio()==null){
            return new ResponseEntity(new Mensaje("El precio debe ser mayor que 0"),HttpStatus.BAD_REQUEST);
        }        
        if(productoServicio.existeByNombre(productoDto.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        Producto producto=new Producto(productoDto.getCodigo(),productoDto.getNombre(),productoDto.getPrecio());
        productoServicio.crearProducto(producto);
        return new ResponseEntity(new Mensaje("Producto creado"),HttpStatus.OK);
    }
    
    
    @PutMapping(path="/update/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable("id") int id ,@RequestBody ProductoDto productoDto){
        
        if(!productoServicio.existeById(id)){
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        }
        if(productoServicio.existeByNombre(productoDto.getNombre()) && 
                productoServicio.getProductoNombre(productoDto.getNombre()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(productoDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(productoDto.getCodigo())) {
            return new ResponseEntity(new Mensaje("El codigo es obligatorio"),HttpStatus.BAD_REQUEST);
        } 
        if(productoDto.getPrecio()<0 || productoDto.getPrecio()==null){
            return new ResponseEntity(new Mensaje("El precio debe ser mayor que 0"),HttpStatus.BAD_REQUEST);
        }        
        
        
        Producto producto=productoServicio.getProductoId(id).get();
        producto.setCodigo(productoDto.getCodigo());
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        productoServicio.crearProducto(producto);
        return new ResponseEntity(new Mensaje("Producto actualizado"),HttpStatus.OK);
    }
    
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable("id") int id){
        
        if(!productoServicio.existeById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        
        productoServicio.borrarId(id);
        return new ResponseEntity(new Mensaje("Producto eliminado"),HttpStatus.OK);     
    
    }


}
