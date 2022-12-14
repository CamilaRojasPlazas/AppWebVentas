import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

/*Clases creadas*/
import { ProductoListComponent } from './producto/producto-list/producto-list.component';
import { ProductoDetalleComponent } from './producto/producto-detalle/producto-detalle.component';
import { ProductoNuevoComponent } from './producto/producto-nuevo/producto-nuevo.component';
import { ProductoEditarComponent } from './producto/producto-editar/producto-editar.component';
import { PagPrincipalComponent } from './vistasGeneral/pag-principal/pag-principal.component';
import { LoginComponent } from './vistasGeneral/login/login.component';
import { MenuComponent } from './vistasGeneral/menu/menu.component';

/*Se importan las clases de conexión*/
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

/*Se importa desde https://www.npmjs.com/package/ngx-toastr*/
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [    
    AppComponent,
    ProductoListComponent,
    ProductoDetalleComponent,
    ProductoNuevoComponent,
    ProductoEditarComponent,
    PagPrincipalComponent,
    LoginComponent,
    MenuComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(), 
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, 
    MatDialogModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
