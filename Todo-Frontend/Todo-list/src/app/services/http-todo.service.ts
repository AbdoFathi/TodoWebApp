import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Todo } from '../model/todo';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HttpTodoService {

  baseUrl : string = 'http://localhost:9090/todo';
  
  constructor(private http:HttpClient) { }

  public findAll() 
  {
    return this.http.get(this.baseUrl);
  }
}
