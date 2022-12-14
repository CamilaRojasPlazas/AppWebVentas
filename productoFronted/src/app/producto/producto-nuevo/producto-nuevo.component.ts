import { Component, OnInit, Input } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/service/producto.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ProductoListComponent } from '../producto-list/producto-list.component';


@Component({
  selector: 'app-producto-nuevo',
  templateUrl: './producto-nuevo.component.html',
  styleUrls: ['./producto-nuevo.component.css'], 
})
export class ProductoNuevoComponent implements OnInit {

  producto: Producto=new Producto();

  constructor(
    private productoService: ProductoService,
    private toastr: ToastrService,
    private router:Router,
    private dialogRef: MatDialog
    ) { }

  ngOnInit(): void {
  }

  createProducto():void{
    this.productoService.guardar(this.producto).subscribe(data => {
      this.toastr.success('Producto creado', 'OK',{
        timeOut: 500,positionClass: 'toast-center-center'
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

  refrescar():void{
    
  }






}
