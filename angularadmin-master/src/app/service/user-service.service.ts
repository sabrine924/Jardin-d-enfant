import { DatePipe } from '@angular/common';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import  {User} from '../model/user';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private baseUrl = 'http://localhost:8081/SpringMVC/servlet/add-user';
  private baseUrl1 = 'http://localhost:8081/SpringMVC/servlet/users/5';
  islogin = false;
  admin = false;
  suser = false;
  choixmenu : string  = 'A';
  listData : User[];
  public dataForm:  FormGroup; 
  constructor(private http: HttpClient,private datePipe: DatePipe) { }
  password(password: String): Observable<Object> {
    
     return this.http.get(`${this.baseUrl1}/${password}`);
   }  
 
  getData(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
 
  createData(info: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, info);
  }
  
  updatedata(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
 
  deleteData(id: number): Observable<any> {
   
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getAll(): Observable<any> {
   
    return this.http.get(`${this.baseUrl}`);
  }
  transformDate(date){
    return this.datePipe.transform(date, 'yyyy-MM-dd');
  }

  
}
