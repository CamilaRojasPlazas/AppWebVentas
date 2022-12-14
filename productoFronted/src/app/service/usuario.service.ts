import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private usuarioURL = 'http://localhost:8081/usuario/';

  constructor(private httpClient: HttpClient) { }

  usuarioLogin(usuario:Usuario):Observable<object>{
    console.log(usuario);
    return this.httpClient.post<object>(this.usuarioURL+"login",usuario);

  }
}
