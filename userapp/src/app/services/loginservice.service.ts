import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../book';
import { User } from '../user';


@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {
  getUrl = "http://ctsuserservice6.ap-northeast-1.elasticbeanstalk.com/user/";
  url = "http://localhost:8088/user/login";

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer foo' 
    })
  };
  performLogin(user: User): Observable<any> {


    //user.role = 'GUEST';
    console.log("perform login" +user);
    // return this.http.post<any>("http://localhost:8088/user/login",user);
    //return this.http.get<User>("http://localhost:8088/user/"+6);

    return this.http.post<any>(`${this.url}`, user);
  }
  getUser(user: User): Observable<any> {


    user.role = 'GUEST';
    console.log(user);

    return this.http.get<User>("http://localhost:8088/user/" + 6);
  }
  createBook(book: Book): Observable<any> {
    console.log(book);
    return this.http.post<any>("http://localhost:8088/user/create/book", book);
  }
  createUser(user: User): Observable<any> {
    // user.role = 'GUEST';
    console.log(user);
    return this.http.post<any>("http://localhost:8088/user/create", user);
  }
  
  getAllBooks(book: Book): Observable<any> {
    return this.http.post<any>("http://localhost:8088/user/book/getAll/user/book/getAll", book);
  }

  getBookById(id: number): Observable<any> {
   
    return this.http.get<any>("/user/get/book/"+ id);
  }

  subscribeBook(id: number, user: string): Observable<any> {
   
    return this.http.get<any>("/user/subscribe/book/"+ id + "/" + user);
  }

  unSubscribeBook(id: number, user: string): Observable<any> {
   
    return this.http.delete<any>("/user/unsubscribe/book/"+ id + "/" + user);
  }
  getAllSubscribedBooks(user: string): Observable<any> {
   
    return this.http.get<any>("http://localhost:8088/user/search/book/user/searchBySubsName/"+ user);
  }
  loginUser(user: User){

    localStorage.setItem("user", user.userName);
    localStorage.setItem("userRole", user.role);
    return true;
  }

  logoutUser(){

    localStorage.removeItem("user");
    localStorage.removeItem("userRole");

  }
  isLoggedIn(){
let user = localStorage.getItem("user");
 if(user==null ||user=='' || user==undefined ){
return false;

 }else{

  return true;
 }
  }
}
