import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Proveedor } from 'src/app/models/proveedor';
import { ProveedorService } from 'src/app/service/proveedor.service';

@Component({
  selector: 'app-proveedor-nuevo',
  templateUrl: './proveedor-nuevo.component.html',
  styleUrls: ['./proveedor-nuevo.component.css']
})
export class ProveedorNuevoComponent implements OnInit {

  proveedor: Proveedor=new Proveedor();


  constructor(
    private dialogRef: MatDialog,
    private toastr: ToastrService,
    private provedorServicio:ProveedorService
  ) { }

  ngOnInit(): void {
  }

  createProveedor():void{ 
    
    this.provedorServicio.guardar(this.proveedor).subscribe(data => {
      this.toastr.success('Proveedor creado', 'OK',{
        timeOut: 1500,positionClass: 'toast-center-center'
      });
      this.provedorServicio.eventDisparadorProveedor.emit();
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
