import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient ) { }

  getAllBook():Observable<any>{
    return this.http.get('/realtimeWeb/search');
  }

  getBook():Observable<any>{
    return this.http.get('/realtimeWeb/books/1/get');
  }


    addBook(book:any): Observable<any> {
      return this.http.post("/realtimeWeb/books/create",book);
    }

    addBookCart(book:any):Observable<any>
  {
    return this.http.post('/realtimeWeb/books/bookscart',book);
  }
  getAllCart():Observable<any>
  {
    return this.http.get('/realtimeWeb/books/bookscart');
  }

}
