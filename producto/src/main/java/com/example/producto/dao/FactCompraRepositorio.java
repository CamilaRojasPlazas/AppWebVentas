
package com.example.producto.dao;

import com.example.producto.modelo.FactCompra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FactCompraRepositorio extends JpaRepository<FactCompra, Integer> {
    
    @Query(value = "SELECT id,fecha,proveedor_id,producto_id,cantidad,total FROM fact_compra;", nativeQuery=true)
    List<FactCompra> listaCompras();
    
}
