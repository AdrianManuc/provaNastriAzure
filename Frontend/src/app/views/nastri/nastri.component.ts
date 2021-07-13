import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { NastriService } from '../../api/nastri.service';

@Component({
  selector: 'app-nastri',
  templateUrl: './nastri.component.html',
  styleUrls: ['./nastri.component.css']
})
export class NastriComponent implements OnInit {

  constructor(public nastriService: NastriService, public router:Router, public routeActive:ActivatedRoute) { }

  public cols;
  public lista;

  ngOnInit(): void {
    // creazione colonne della tabella con assegnazione dei dati che voglio visualizzare
    this.cols =[
      {field: "id", header: "ID nastro"},
      {field: "sezione", header: "Sezione"},
      {field: "note", header: "Note"}
    ]
    // chiamata getAll che ritorna tutti i dati e li mette all'interno della lista
    this.nastriService.getAll().subscribe((resp)=>{
      this.lista = resp.response;
      console.log("Lista ", this.lista);
    })
  }

  visualizza(id: any) {
    // passo l'id che mi interessa
    this.router.navigate(["/mezzi-posizioni/" + id]);
  }

}
