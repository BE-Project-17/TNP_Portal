import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { catchError, tap, Observable } from 'rxjs';
import { handleError } from '../error-handler/error-handler';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private http:HttpClient) {}

  getRequest(url: string): Observable<HttpResponse<any>>{
    return this.http.get<any>(url,{observe: 'response'}).pipe(
      tap(data => {}),
      catchError(handleError)
    );
  }

  postRequest(url: string, body: any): Observable<HttpResponse<any>>{
    return this.http.post<any>(url,body,{observe: 'response'}).pipe(
      tap(data => {}),
      catchError(handleError)
    );
  }

  putRequest(url: string, body: any): Observable<HttpResponse<any>>{
    return this.http.put<any>(url,body,{observe: 'response'}).pipe(
      tap(data => {}),
      catchError(handleError)
    );
  }
  deleteRequest(url: string): Observable<HttpResponse<any>>{
    return this.http.delete<any>(url,{observe: 'response'}).pipe(
      tap(data => {}),
      catchError(handleError)
    );
  }
}
