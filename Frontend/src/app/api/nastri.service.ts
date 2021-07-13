import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class NastriService {

  constructor(public apiService: ApiService) { }
  private readonly path = "nastri";

  public getAll(): Observable<any>{
    return this.apiService.get(this.path)
  }
  public getById(id: number): Observable<any>{
    return this.apiService.getById(this.path, id + "")
  }
}
