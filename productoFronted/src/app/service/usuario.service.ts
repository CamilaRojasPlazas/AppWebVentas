import { HttpClient } from '@angular/common/http';
import { Injectable,EventEmitter,Output } from '@angular/core';
import { Usuario } from '../models/usuario';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private usuarioURL = 'http://localhost:8081/usuario/';

  constructor(private httpClient: HttpClient) { }


  usuarioLogin(usuario:Usuario):Observable<object>{
    return this.httpClient.post<object>(this.usuarioURL+"login",usuario);
  }

  public lista(): Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(this.usuarioURL+"list");
  }

  public guardar(usuario: Usuario): Observable<any>{
    return this.httpClient.post<any>(this.usuarioURL+'create',usuario);
  }

  public detailId(id: number): Observable<Usuario>{
    return this.httpClient.get<Usuario>(this.usuarioURL+`detail/${id}`);
  }

  public updateId(id: number, usuario:Usuario): Observable<any>{
    return this.httpClient.put<any>(this.usuarioURL+`update/${id}`,usuario);
  }

  public eliminar(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.usuarioURL+`eliminar/${id}`);
  }


  @Output() eventDisparadorUsuario:EventEmitter<any> =new EventEmitter();
  
}



