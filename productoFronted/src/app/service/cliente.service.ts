import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private clienteURL = 'http://localhost:8081/cliente/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Cliente[]>{
    return this.httpClient.get<Cliente[]>(this.clienteURL+"list");
  }

  public guardar(cliente: Cliente): Observable<any>{
    return this.httpClient.post<any>(this.clienteURL+'create',cliente);
  }

  public detailId(id: number): Observable<Cliente>{
    return this.httpClient.get<Cliente>(this.clienteURL+`detail/${id}`);
  }

  public updateId(id: number, cliente:Cliente): Observable<any>{
    return this.httpClient.put<any>(this.clienteURL+`update/${id}`,cliente);
  }

  public eliminar(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.clienteURL+`eliminar/${id}`);
  }

  @Output() eventDisparadorCliente:EventEmitter<any> =new EventEmitter();

}
