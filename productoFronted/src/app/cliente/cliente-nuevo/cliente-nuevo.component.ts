import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/service/cliente.service';

@Component({
  selector: 'app-cliente-nuevo',
  templateUrl: './cliente-nuevo.component.html',
  styleUrls: ['./cliente-nuevo.component.css']
})
export class ClienteNuevoComponent implements OnInit {

  cliente: Cliente=new Cliente();

  constructor(
    private clienteServicio:ClienteService,
    private dialogRef: MatDialog,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
  }

  createCliente():void{ 

    this.clienteServicio.guardar(this.cliente).subscribe(data => {
      this.toastr.success('Cliente creado', 'OK',{
        timeOut: 1500,positionClass: 'toast-center-center'
      });
      this.clienteServicio.eventDisparadorCliente.emit();
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
