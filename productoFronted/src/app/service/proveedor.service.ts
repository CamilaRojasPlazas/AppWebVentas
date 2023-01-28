import { HttpClient } from '@angular/common/http';
import { Injectable,EventEmitter,Output } from '@angular/core';
import { Observable } from 'rxjs';
import { Proveedor } from '../models/proveedor';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  private proveedorURL = 'http://localhost:8081/proveedor/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Proveedor[]>{
    return this.httpClient.get<Proveedor[]>(this.proveedorURL+"list");
  }

  public guardar(proveedor: Proveedor): Observable<any>{
    return this.httpClient.post<any>(this.proveedorURL+'create',proveedor);
  }

  public detailId(id: number): Observable<Proveedor>{
    return this.httpClient.get<Proveedor>(this.proveedorURL+`detail/${id}`);
  }

  public updateId(id: number, proveedor:Proveedor): Observable<any>{
    return this.httpClient.put<any>(this.proveedorURL+`update/${id}`,proveedor);
  }

  public eliminar(id:number): Observable<any>{
    return this.httpClient.delete<any>(this.proveedorURL+`eliminar/${id}`);
  }

  @Output() eventDisparadorProveedor:EventEmitter<any> =new EventEmitter();

}
