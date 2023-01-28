import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/service/cliente.service';

@Component({
  selector: 'app-cliente-editar',
  templateUrl: './cliente-editar.component.html',
  styleUrls: ['./cliente-editar.component.css']
})
export class ClienteEditarComponent implements OnInit {

  cliente: Cliente=new Cliente();

  constructor(
    private clienteServicio:ClienteService,
    private toastr: ToastrService,
    private dialogRef: MatDialog
  ) { }

  ngOnInit(): void {
    this.obtenerCliente();
  }

  obtenerCliente():void{
    let id=localStorage.getItem('id');
    let idNumber=Number(id);
    this.clienteServicio.detailId(idNumber).subscribe(
      data =>{
        this.cliente=data;
      },
      err =>{
        this.toastr.error(err.error.mensaje, 'Faild',{
          timeOut: 2000,positionClass: 'toast-center-center'
        });
      }
    );
  }

  editarCliente():void{
    let id=localStorage.getItem('id');
    let idNumber=Number(id);
    this.clienteServicio.updateId(idNumber,this.cliente).subscribe(data =>{
      this.toastr.success('Cliente actualizado', 'OK',{
        timeOut: 1000,positionClass: 'toast-center-center'
      });
      this.dialogRef.closeAll(); 
      this.clienteServicio.eventDisparadorCliente.emit();
    }, 
    err => {
      this.toastr.error(err.error.mensaje, 'Faild',{
        timeOut: 500,positionClass: 'toast-center-center'
      });
    }      
    );
  }

}
