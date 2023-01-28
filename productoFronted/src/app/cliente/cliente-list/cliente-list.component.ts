import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/service/cliente.service';
import { ClienteEditarComponent } from '../cliente-editar/cliente-editar.component';
import { ClienteNuevoComponent } from '../cliente-nuevo/cliente-nuevo.component';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {

  /*Se crea el array de productos*/ 
  cliente: Cliente=new Cliente();
  clientes: Cliente[]=[];


  constructor(
    private clienteServicio:ClienteService,
    private poputUsuario: MatDialog,
    private toastr: ToastrService,
    private dialogRef: MatDialog
  ) { }

  ngOnInit(): void {
    this.getClientes();
    this.clienteServicio.eventDisparadorCliente.subscribe(()=>{
      this.getClientes();
    })
  }

  //obtiene la lista de usuarios
  getClientes(){
    this.clienteServicio.lista().subscribe(datos => {
      this.clientes= datos;
    },
    err =>{
      console.log(err);
    });    
  }

  public borrar(id:number){

    this.clienteServicio.eliminar(id).subscribe(data =>{
      this.toastr.success('Cliente eliminado', 'OK',{
        timeOut: 1000,positionClass: 'toast-center-center'
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

  //abre el modal para crear un nuevo usuario
  openDialog(){
    this.poputUsuario.open(ClienteNuevoComponent);
  }

  openDialogModificar(clienteMod:Cliente){
    localStorage.setItem("id",clienteMod.id.toString());
    this.poputUsuario.open(ClienteEditarComponent);
  }

}
