
package com.example.producto.servicios;

import com.example.producto.dao.FactCompraRepositorio;
import com.example.producto.modelo.FactCompra;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */

@Service
@Transactional
public class FactCompraServicio {
    
    @Autowired
    FactCompraRepositorio factCompraRepositorio;
    
    public List <FactCompra> getListaCompras(){
        return factCompraRepositorio.listaCompras();
    }
    
    public void crearFacturaCompra(FactCompra facturaCompra){
       factCompraRepositorio.save(facturaCompra);
    }
    
    
    
}
