import { Producto } from "./producto";
import { Proveedor } from "./proveedor";

export class FactCompra {

    id! :number;
    fecha!: Date;
    proveedor!: number;
    producto!: number;
    cantidad!: number;
    total! : number;

    constructor(){   
    }
}
