import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { roles } from 'src/app/models/model.interface';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuario-nuevo',
  templateUrl: './usuario-nuevo.component.html',
  styleUrls: ['./usuario-nuevo.component.css']
})
export class UsuarioNuevoComponent implements OnInit {

  usuario: Usuario=new Usuario();
  
  //Variables para el comboBox
  public arrayRoles:Array<roles> =[
    {id:1,name:"Administrador"},
    {id:2,name:"Vendedor"}
  ] 

  constructor(
    private dialogRef: MatDialog,
    private toastr: ToastrService,
    private usuarioServi:UsuarioService
  ) { }

  ngOnInit(): void {
  }

  createUsuario():void{
    
    this.usuarioServi.guardar(this.usuario).subscribe(data => {
      this.toastr.success('Usuario creado', 'OK',{
        timeOut: 1000,positionClass: 'toast-center-center'
      });
      this.usuarioServi.eventDisparadorUsuario.emit();
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
