import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from 'src/app/models/Users';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  
  constructor(private httpClient:HttpClient) { }

  getAll():Observable<Users[]>{
    
    return this.httpClient.get(environment.getAll) as Observable<Users[]>;


  }
}
