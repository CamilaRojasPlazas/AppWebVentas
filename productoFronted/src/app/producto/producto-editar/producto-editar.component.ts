import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/service/producto.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-producto-editar',
  templateUrl: './producto-editar.component.html',
  styleUrls: ['./producto-editar.component.css']
})
export class ProductoEditarComponent implements OnInit {


  producto: Producto=new Producto();

  constructor(
    private productoService: ProductoService,
    private activateRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router:Router,
    private dialogRef: MatDialog) { }

  ngOnInit(){
    this.obtenerProducto();
  }

  obtenerProducto():void{
    let id=localStorage.getItem('id');
    let idNumber=Number(id);
    this.productoService.detailId(idNumber).subscribe(
      data =>{
        this.producto=data;
      },
      err =>{
        this.toastr.error(err.error.mensaje, 'Faild',{
          timeOut: 2000,positionClass: 'toast-center-center'
        });
      }
    );
  }

  editarProducto():void{
    let id=localStorage.getItem('id');
    let idNumber=Number(id);
    this.productoService.updateId(idNumber,this.producto).subscribe(data =>{
      this.toastr.success('Producto actualizado', 'OK',{
        timeOut: 1000,positionClass: 'toast-center-center'
      });
      this.dialogRef.closeAll(); 
    }, 
    err => {
      this.toastr.error(err.error.mensaje, 'Faild',{
        timeOut: 500,positionClass: 'toast-center-center'
      });
    }      
    );
  }

}
