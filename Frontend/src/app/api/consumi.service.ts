import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ConsumiService {

  constructor(public apiService: ApiService) { }
  private readonly path = "consumi";

  public getAll(): Observable<any>{
    return this.apiService.get(this.path)
  }
}
