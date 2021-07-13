import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class VelocitaService {

  constructor(public apiService: ApiService) { }
  private readonly path = "velocita";

  public getAll(): Observable<any>{
    return this.apiService.get(this.path)
  }
}
