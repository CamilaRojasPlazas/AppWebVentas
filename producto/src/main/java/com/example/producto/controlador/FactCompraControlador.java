
package com.example.producto.controlador;

import com.example.producto.dto.FactCompraDto;
import com.example.producto.dto.Mensaje;
import com.example.producto.modelo.FactCompra;
import com.example.producto.servicios.FactCompraServicio;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/compras")
@CrossOrigin(origins = "http://localhost:4200")
public class FactCompraControlador {
    
    @Autowired
    FactCompraServicio factCompraServicio;
    
    /*-------------------------METODOS DE LAS COMPRAS -----------------------------------*/
    @GetMapping(path="/list")
    public ResponseEntity<List<FactCompra>> lista(){
        
        List<FactCompra> lista=factCompraServicio.getListaCompras();   
        return new ResponseEntity<List<FactCompra>>(lista,HttpStatus.OK);
    }
    
    @PostMapping(path="/create")
    public ResponseEntity<?> crearFacturaCompra(@RequestBody FactCompraDto facturaCompraDto){
        
        if(facturaCompraDto.getFecha()==null){
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        
        if(facturaCompraDto.getProveedor()==null) {
            return new ResponseEntity(new Mensaje("El proveedor es obligatorio"),HttpStatus.BAD_REQUEST);
        }        
        if(facturaCompraDto.getProducto()==null){
            return new ResponseEntity(new Mensaje("La producto es obligatorio"),HttpStatus.BAD_REQUEST);
        }    
        
        if(facturaCompraDto.getCantidad()<=0){
            return new ResponseEntity(new Mensaje("La cantidad es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        
        if(facturaCompraDto.getTotal()<=0){
            return new ResponseEntity(new Mensaje("El total tiene un error"),HttpStatus.BAD_REQUEST);
        }   
        
        FactCompra newFacturaCompra=new FactCompra(facturaCompraDto.getFecha(),facturaCompraDto.getProveedor(),
        facturaCompraDto.getProducto(),facturaCompraDto.getCantidad(),facturaCompraDto.getTotal());
        factCompraServicio.crearFacturaCompra(newFacturaCompra);
        return new ResponseEntity(new Mensaje("Factura creada"),HttpStatus.OK);
    }
    
    
}
