import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';
import { MatDialog } from '@angular/material/dialog';
import { UsuarioNuevoComponent } from '../usuario-nuevo/usuario-nuevo.component';
import { UsuarioEditarComponent } from '../usuario-editar/usuario-editar.component';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-usuario-lista',
  templateUrl: './usuario-lista.component.html',
  styleUrls: ['./usuario-lista.component.css']
})
export class UsuarioListaComponent implements OnInit {

  /*Se crea el array de productos*/ 
  usuarios: Usuario[]=[];
  usuario: Usuario=new Usuario();

  constructor(
    private usuarioService: UsuarioService,
    private poputUsuario: MatDialog,
    private toastr: ToastrService,
    private dialogRef: MatDialog
  ) { }

  ngOnInit(): void {
    this.getUsuarios();
    this.usuarioService.eventDisparadorUsuario.subscribe(()=>{
      this.getUsuarios();
    })
  }

  //obtiene la lista de usuarios
  getUsuarios(){
    this.usuarioService.lista().subscribe(datos => {
      this.usuarios = datos;
    },
    err =>{
      console.log(err);
    });
    
  }

  public borrar(id:number){

    this.usuarioService.eliminar(id).subscribe(data =>{
      this.toastr.success('Usuario eliminado', 'OK',{
        timeOut: 1000,positionClass: 'toast-center-center'
      });
      this.dialogRef.closeAll(); 
      this.usuarioService.eventDisparadorUsuario.emit();
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
    this.poputUsuario.open(UsuarioNuevoComponent);
  }

  //abre el modal para actualizar un usuario
  openDialogModificar(userMod:Usuario){
    localStorage.setItem("id",userMod.id.toString());
    this.poputUsuario.open(UsuarioEditarComponent);
  }

}
