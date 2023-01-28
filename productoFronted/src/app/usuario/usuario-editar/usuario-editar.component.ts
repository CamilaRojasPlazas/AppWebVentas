import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { roles } from 'src/app/models/model.interface';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuario-editar',
  templateUrl: './usuario-editar.component.html',
  styleUrls: ['./usuario-editar.component.css']
})
export class UsuarioEditarComponent implements OnInit {

  usuario: Usuario=new Usuario();
  
  //Variables para el comboBox
  public arrayRoles:Array<roles> =[
    {id:1,name:"Administrador"},
    {id:2,name:"Vendedor"}
  ] 


  constructor(
    private usuarioService: UsuarioService,
    private toastr: ToastrService,
    private dialogRef: MatDialog
  ) { }

  ngOnInit(): void {
    this.obtenerUsuario();
  }

  obtenerUsuario():void{
    let id=localStorage.getItem('id');
    let idNumber=Number(id);
    this.usuarioService.detailId(idNumber).subscribe(
      data =>{
        this.usuario=data;
      },
      err =>{
        this.toastr.error(err.error.mensaje, 'Faild',{
          timeOut: 2000,positionClass: 'toast-center-center'
        });
      }
    );
  }

  editarUsuario():void{
    let id=localStorage.getItem('id');
    let idNumber=Number(id);
    this.usuarioService.updateId(idNumber,this.usuario).subscribe(data =>{
      this.toastr.success('Usuario actualizado', 'OK',{
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

}
