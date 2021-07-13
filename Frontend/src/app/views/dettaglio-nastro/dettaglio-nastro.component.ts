import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NastriService } from '../../api/nastri.service';

@Component({
  selector: 'app-dettaglio-nastro',
  templateUrl: './dettaglio-nastro.component.html',
  styleUrls: ['./dettaglio-nastro.component.css']
})
export class DettaglioNastroComponent implements OnInit {

  constructor(public nastriService: NastriService, public router:Router, public routeActive:ActivatedRoute) { }

  public cols;
  public lista : any[] = [];
  // prendo l'id passato dall'altra pagina
  public id = this.routeActive.snapshot.params["id"];

  ngOnInit(): void {
    // creazione colonne della tabella con assegnazione dei dati che voglio visualizzare
    this.cols =[
      {field: "id", header: "ID nastro"},
      {field: "sezione", header: "Sezione"},
      {field: "note", header: "Note"}
    ]
    // chiamata getAll che ritorna tutti i dati e li mette all'interno della lista
    // uso la getAll e non il getById perchè per creare la tabella mi serve un array
    this.nastriService.getAll().subscribe((resp)=>{
      console.log("Resp", resp.response);
      resp.response.forEach(element => {
        console.log("Element: ", element);
        if(element.id == this.id){
          // pusho solo l'element con l'id che mi serve
          this.lista.push(element);
        }
      });
    })
  }

}
