import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

/*Impoortaciones internas*/
import { ProductoEditarComponent } from './producto/producto-editar/producto-editar.component';
import { ProductoListComponent } from './producto/producto-list/producto-list.component';
import { ProductoNuevoComponent } from './producto/producto-nuevo/producto-nuevo.component';
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


const routes: Routes = [
  /*Se definen las rutas*/
  {path: '', component:PagPrincipalComponent},
  {path: 'productos', component:ProductoListComponent},
  {path: 'nuevo', component:ProductoNuevoComponent},
  {path: 'editar/:id', component:ProductoEditarComponent},
  {path: 'login', component:LoginComponent},
  {path: 'menu', component:MenuComponent},
  {path: 'usuarios', component:UsuarioListaComponent},
  {path: 'newUsr', component:UsuarioNuevoComponent},
  {path: 'updateUsr', component:UsuarioEditarComponent},
  {path: 'proveedor', component:ProveedorListComponent},
  {path: 'newProveedor', component:ProveedorNuevoComponent},
  {path: 'updateProveedor', component:ProveedorEditarComponent},
  {path: 'clientes', component:ClienteListComponent},
  {path: 'newClientes', component:ClienteNuevoComponent},
  {path: 'updateCliente', component:ClienteEditarComponent},
  {path: 'compras', component:ComprasListarComponent},


  /*Lo redirige a la RAIZ*/
  {path: '**',redirectTo:'', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
