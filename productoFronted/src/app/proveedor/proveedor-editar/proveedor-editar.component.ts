import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Proveedor } from 'src/app/models/proveedor';
import { ProveedorService } from 'src/app/service/proveedor.service';

@Component({
  selector: 'app-proveedor-editar',
  templateUrl: './proveedor-editar.component.html',
  styleUrls: ['./proveedor-editar.component.css']
})
export class ProveedorEditarComponent implements OnInit {

  proveedor: Proveedor=new Proveedor();

  constructor(
    private proveedorServicio:ProveedorService,
    private toastr: ToastrService,
    private dialogRef: MatDialog
  ) { }

  ngOnInit(): void {
    this.obtenerProveedor();
  }

  obtenerProveedor():void{
    let id=localStorage.getItem('id');
    let idNumber=Number(id);
    this.proveedorServicio.detailId(idNumber).subscribe(
      data =>{
        this.proveedor=data;
      },
      err =>{
        this.toastr.error(err.error.mensaje, 'Faild',{
          timeOut: 2000,positionClass: 'toast-center-center'
        });
      }
    );
  }

  editarProveedor():void{
    let id=localStorage.getItem('id');
    let idNumber=Number(id);
    this.proveedorServicio.updateId(idNumber,this.proveedor).subscribe(data =>{
      this.toastr.success('Proveedor actualizado', 'OK',{
        timeOut: 1000,positionClass: 'toast-center-center'
      });
      this.dialogRef.closeAll(); 
      this.proveedorServicio.eventDisparadorProveedor.emit();
    }, 
    err => {
      this.toastr.error(err.error.mensaje, 'Faild',{
        timeOut: 500,positionClass: 'toast-center-center'
      });
    }      
    );
  }

}
