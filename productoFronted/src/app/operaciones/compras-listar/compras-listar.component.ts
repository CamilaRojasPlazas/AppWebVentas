import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { numbers } from '@material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { FactCompra } from 'src/app/models/fact-compra';
import { Producto } from 'src/app/models/producto';
import { Proveedor } from 'src/app/models/proveedor';
import { FactCompraService } from 'src/app/service/fact-compra.service';
import { ProductoService } from 'src/app/service/producto.service';
import { ProveedorService } from 'src/app/service/proveedor.service';

@Component({
  selector: 'app-compras-listar',
  templateUrl: './compras-listar.component.html',
  styleUrls: ['./compras-listar.component.css']
})
export class ComprasListarComponent implements OnInit {

  /*Se crea el array de productos*/ 
  facturasCompra: FactCompra[]=[];
  proveedores: Proveedor[]=[];
  productos: Producto[]=[];


  facturaCompra: FactCompra=new FactCompra();
  elProducto: Producto=new Producto();

  constructor(
    private facturaCompraServicio:FactCompraService,
    private proveedorServicio:ProveedorService,
    private productoServicio:ProductoService,
    private toastr: ToastrService,
    private dialogRef: MatDialog  ) { }

  ngOnInit(): void {
    this.getFactCompras();
    this.getProveedores();
    this.getProductos();
  }

  //obtiene la lista de compras
  getFactCompras(){
    this.facturaCompraServicio.lista().subscribe(datos => {
      this.facturasCompra = datos;
    },
    err =>{
      console.log(err);
    });
  }

  //obtiene la lista de proveedores
  getProveedores(){
    this.proveedorServicio.lista().subscribe(datos => {
      this.proveedores = datos;
    },
    err =>{
      console.log(err);
    });
  }

  //obtiene la lista de proveedores
  getProductos(){
    this.productoServicio.lista().subscribe(datos => {
      this.productos = datos;
    },
    err =>{
      console.log(err);
    });
  }

  crearFactura():void{

    //se busca el producto para conocer el precio unitario
    this.productoServicio.detailId(this.facturaCompra.producto).subscribe(
      dataProducto =>{        
        this.elProducto=dataProducto;
        this.facturaCompra.total=this.facturaCompra.cantidad*dataProducto.precio;

        alert((this.facturaCompra.fecha));
        alert((this.facturaCompra.proveedor));
        alert((this.facturaCompra.producto));
        alert((this.facturaCompra.cantidad));
        alert( (this.facturaCompra.total));

        let idProveedor:number=Number(this.facturaCompra.proveedor);
        this.facturaCompra.proveedor=idProveedor;

        //se crea la factura
        this.facturaCompraServicio.guardar(this.facturaCompra).subscribe(data => {
          alert("Entre aqui");
          this.toastr.success('Factura creada', 'OK',{
            timeOut: 2000,positionClass: 'toast-center-center'
          });
        },
        err => {
          this.toastr.error(err.error.mensaje, 'Faild',{
            timeOut: 2000,positionClass: 'toast-center-center'
          });
        }
        );  

      },
      err =>{
        this.toastr.error(err.error.mensaje, 'Faild',{
          timeOut: 2000,positionClass: 'toast-center-center'
        });
      }
    );

  }

 




}
