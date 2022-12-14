import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private productoURL = 'http://localhost:8081/producto/';

  constructor( private httpClient: HttpClient) { }

  public lista(): Observable<Producto[]>{
    return this.httpClient.get<Producto[]>(this.productoURL+"list");
  }


  public detailId(id: number): Observable<Producto>{
    return this.httpClient.get<Producto>(this.productoURL+`detail/${id}`);
  }

  public detailName(nombre: string): Observable<Producto>{
    return this.httpClient.get<Producto>(this.productoURL+`detailname/${nombre}`);
  }

  public guardar(producto: Producto): Observable<any>{
    return this.httpClient.post<any>(this.productoURL+'create',producto);
  }

  public updateId(id: number, producto:Producto): Observable<any>{
    return this.httpClient.put<any>(this.productoURL+`update/${id}`,producto);
  }

  public eliminar(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.productoURL+`delete/${id}`);
  }
  
}
