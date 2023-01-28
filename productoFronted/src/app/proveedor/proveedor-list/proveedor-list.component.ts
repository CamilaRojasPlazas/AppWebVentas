import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Proveedor } from 'src/app/models/proveedor';
import { ProveedorService } from 'src/app/service/proveedor.service';
import { ProveedorEditarComponent } from '../proveedor-editar/proveedor-editar.component';
import { ProveedorNuevoComponent } from '../proveedor-nuevo/proveedor-nuevo.component';

@Component({
  selector: 'app-proveedor-list',
  templateUrl: './proveedor-list.component.html',
  styleUrls: ['./proveedor-list.component.css']
})
export class ProveedorListComponent implements OnInit {

  /*Se crea el array de productos*/ 
  proveedores: Proveedor[]=[];
  proveedor: Proveedor=new Proveedor();

  constructor(
    private proveedorService: ProveedorService,
    private poputUsuario: MatDialog,
    private toastr: ToastrService,
    private dialogRef: MatDialog
  ) { }

  ngOnInit(): void {
    this.getProveedores();
    this.proveedorService.eventDisparadorProveedor.subscribe(()=>{
      this.getProveedores();
    })
  }

  //obtiene la lista de usuarios
  getProveedores(){
    this.proveedorService.lista().subscribe(datos => {
      this.proveedores = datos;
    },
    err =>{
      console.log(err);
    });    
  }

  public borrar(id:number){

    this.proveedorService.eliminar(id).subscribe(data =>{
      this.toastr.success('Proveedor eliminado', 'OK',{
        timeOut: 1000,positionClass: 'toast-center-center'
      });
      this.dialogRef.closeAll(); 
      this.proveedorService.eventDisparadorProveedor.emit();
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
    this.poputUsuario.open(ProveedorNuevoComponent);
  }

  //abre el modal para actualizar un usuario
  openDialogModificar(proveedorMod:Proveedor){
    localStorage.setItem("id",proveedorMod.id.toString());
    this.poputUsuario.open(ProveedorEditarComponent);
  }

}
