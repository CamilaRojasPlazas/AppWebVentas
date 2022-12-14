import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';




@Component({
  selector: 'app-pag-principal',
  templateUrl: './pag-principal.component.html',
  styleUrls: ['./pag-principal.component.css']
})
export class PagPrincipalComponent implements OnInit {


  constructor(private poputLogin: MatDialog) { }

  ngOnInit(): void {
  }

  openDialog(){
    this.poputLogin.open(LoginComponent);
  }






}
