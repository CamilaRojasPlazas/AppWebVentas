import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario: Usuario=new Usuario();


  constructor(private usuarioService: UsuarioService, 
    public router: Router,
    private dialogRef: MatDialog,
    private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  usuarioLogin(){
    
    console.log(this.usuario);

      this.usuarioService.usuarioLogin(this.usuario).subscribe(data => {
      this.dialogRef.closeAll();
      this.router.navigateByUrl('/menu');      
    }, 
    err => {
      this.toastr.error("Ingrese correctamente los datos", 'Faild',{
        timeOut: 2000,positionClass: 'toast-center-center'
      });        
    }
    );
  }


}
