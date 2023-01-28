import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

/*Clases creadas*/
import { ProductoListComponent } from './producto/producto-list/producto-list.component';
import { ProductoNuevoComponent } from './producto/producto-nuevo/producto-nuevo.component';
import { ProductoEditarComponent } from './producto/producto-editar/producto-editar.component';
import { PagPrincipalComponent } from './vistasGeneral/pag-principal/pag-principal.component';
import { LoginComponent } from './vistasGeneral/login/login.component';
import { MenuComponent } from './vistasGeneral/menu/menu.component';
import { UsuarioListaComponent } from './usuario/usuario-lista/usuario-lista.component';
import { UsuarioNuevoComponent } from './usuario/usuario-nuevo/usuario-nuevo.component';
import { UsuarioEditarComponent } from './usuario/usuario-editar/usuario-editar.component';
import { ProveedorListComponent } from './proveedor/proveedor-list/proveedor-list.component';
import { ProveedorNuevoComponent } from './proveedor/proveedor-nuevo/proveedor-nuevo.component';
import { ProveedorEditarComponent } from './proveedor/proveedor-editar/proveedor-editar.component';
import { ClienteListComponent } from './cliente/cliente-list/cliente-list.component';
import { ClienteNuevoComponent } from './cliente/cliente-nuevo/cliente-nuevo.component';
import { ClienteEditarComponent } from './cliente/cliente-editar/cliente-editar.component';
import { ComprasListarComponent } from './operaciones/compras-listar/compras-listar.component';


/*Se importan las clases de conexión*/
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

/*Se importa desde https://www.npmjs.com/package/ngx-toastr*/
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ComboBoxModule } from '@syncfusion/ej2-angular-dropdowns';
import { MatDialogModule } from '@angular/material/dialog';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  declarations: [    
    AppComponent,
    ProductoListComponent,
    ProductoNuevoComponent,
    ProductoEditarComponent,
    PagPrincipalComponent,
    LoginComponent,
    MenuComponent,
    UsuarioListaComponent,
    UsuarioNuevoComponent,
    UsuarioEditarComponent,
    ProveedorListComponent,
    ProveedorNuevoComponent,
    ProveedorEditarComponent,
    ClienteListComponent,
    ClienteNuevoComponent,
    ClienteEditarComponent,
    ComprasListarComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(), 
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, 
    MatDialogModule, 
    ComboBoxModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
