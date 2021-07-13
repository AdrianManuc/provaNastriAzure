import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ConsumiService } from '../../api/consumi.service';
import { VelocitaService } from '../../api/velocita.service';

@Component({
  selector: 'app-monitoraggio',
  templateUrl: './monitoraggio.component.html',
  styleUrls: ['./monitoraggio.component.css']
})
export class MonitoraggioComponent implements OnInit {

  constructor(public velocitaService: VelocitaService, public consumiService: ConsumiService, public router:Router, public routeActive:ActivatedRoute) { }

  public colsVelocita;
  public colsConsumi;
  public listaV;
  public listaC;

  ngOnInit(): void {
    // creazione colonne della tabella con assegnazione dei dati che voglio visualizzare
    this.colsVelocita =[
      {field: "velocitaId", header: "ID velocità"},
      {field: "nastroId", header: "Nastro ID"},
      {field: "velocita", header: "Velocità metri/minuto"}
    ]

    this.colsConsumi =[
      {field: "consumoId", header: "ID consumo"},
      {field: "nastroId", header: "Nastro ID"},
      {field: "consumo", header: "Consumo in Watt"}
    ]
    // chiamata getAll che ritorna tutti i dati e li mette all'interno della lista
    this.velocitaService.getAll().subscribe((resp)=>{
      this.listaV = resp.response;
      console.log("Lista consumi", this.listaV);
    })

    this.consumiService.getAll().subscribe((resp)=>{
      this.listaC = resp.response;
      console.log("Lista consumi", this.listaC);
    })
  }

  visualizza(id: any) {
    // passo l'id che mi interessa
    this.router.navigate(["/dettaglio-nastro/" + id]);
  }

}
