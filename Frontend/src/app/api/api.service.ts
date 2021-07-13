import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class ApiService {
  private readonly host = "https://provaesamenastri123.azurewebsites.net/api";
  constructor(private http: HttpClient) {}

  public get(path: string): Observable<any> {
    return this.http.get(this.host + "/" + path);
  }
  public post(path: string, body: any): Observable<any> {
    return this.http.post(this.host + "/" + path, body);
  }
  public delete(path: string): Observable<any> {
    return this.http.delete(this.host + "/" + path);
  }
  public put(path: string, body: any): Observable<any> {
    return this.http.put(this.host + "/" + path, body);
  }
  public patch(path: string, body: any): Observable<any> {
    return this.http.patch(this.host + "/" + path, body);
  }
  public getById(path: string, id: string): Observable<any> {
    return this.http.get(this.host + "/" + path +  "/" + id);
  }
}
