import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/service/producto.service';
import { MatDialog } from '@angular/material/dialog';
import { ProductoNuevoComponent } from '../producto-nuevo/producto-nuevo.component';
import { ToastrService } from 'ngx-toastr';
import { ProductoEditarComponent } from '../producto-editar/producto-editar.component';


@Component({
  selector: 'app-producto-list',
  templateUrl: './producto-list.component.html',
  styleUrls: ['./producto-list.component.css']
})
export class ProductoListComponent implements OnInit {

  /*Se crea el array de productos*/ 
  productos: Producto[]=[];
  producto: Producto=new Producto();

  constructor(
    private productoService: ProductoService, 
    private poputProduct: MatDialog,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getProductos();
    this.productoService.eventDisparador.subscribe(() => {
      this.getProductos();
    }) 
  }

  //obtiene la lista de productos
  getProductos(){
    this.productoService.lista().subscribe(datos => {
      this.productos = datos;
    },
    err =>{
      console.log(err);
    });
  }

  //Borra el producto
  public borrar(id:number, cantidad:number){

    if(cantidad==0){
      this.productoService.eliminar(id).subscribe(
        date => {
          this.toastr.success('Producto eliminado', 'OK',{
            timeOut: 1000,positionClass: 'toast-center-center'
          });
          this.getProductos();
        },
        err =>{
          this.toastr.error(err.error.mensaje, 'Faild',{
            timeOut: 2000,positionClass: 'toast-center-center'
          });        
        }
      );
    }
    else{
      this.toastr.error("El stock es mayor a 0, no se puede borrar", 'Faild',{
        timeOut: 2000,positionClass: 'toast-center-center'
      });
    }
    
  }

  //abre el modal para crear un nuevo producto
  openDialog(){
    this.poputProduct.open(ProductoNuevoComponent);
  }

  openDialogModificar(producMod:Producto){
    localStorage.setItem("id",producMod.id.toString());
    this.poputProduct.open(ProductoEditarComponent);
  }
}
