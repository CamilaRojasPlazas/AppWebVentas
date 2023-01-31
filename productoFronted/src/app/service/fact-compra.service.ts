import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FactCompra } from '../models/fact-compra';

@Injectable({
  providedIn: 'root'
})
export class FactCompraService {

  private comprasURL = 'http://localhost:8081/compras/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<FactCompra[]>{
    return this.httpClient.get<FactCompra[]>(this.comprasURL+"list");
  }

  public guardar(facturaCompra: FactCompra): Observable<any>{
    return this.httpClient.post<any>(this.comprasURL+'create',facturaCompra);
  }


  
}
