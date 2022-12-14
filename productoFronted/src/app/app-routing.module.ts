import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

/*Impoortaciones internas*/
import { ProductoDetalleComponent } from './producto/producto-detalle/producto-detalle.component';
import { ProductoEditarComponent } from './producto/producto-editar/producto-editar.component';
import { ProductoListComponent } from './producto/producto-list/producto-list.component';
import { ProductoNuevoComponent } from './producto/producto-nuevo/producto-nuevo.component';
import { PagPrincipalComponent } from './vistasGeneral/pag-principal/pag-principal.component';
import { LoginComponent } from './vistasGeneral/login/login.component';
import { MenuComponent } from './vistasGeneral/menu/menu.component';

const routes: Routes = [
  /*Se definen las rutas*/
  {path: '', component:PagPrincipalComponent},
  {path: 'productos', component:ProductoListComponent},
  {path: 'detalle/:id', component:ProductoDetalleComponent},
  {path: 'nuevo', component:ProductoNuevoComponent},
  {path: 'editar/:id', component:ProductoEditarComponent},
  {path: 'login', component:LoginComponent},
  {path: 'menu', component:MenuComponent},

  /*Lo redirige a la RAIZ*/
  {path: '**',redirectTo:'', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
