import { Injectable } from '@angular/core';


import { environment } from 'environments/environment';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Enviament } from '../model/enviament';

import { Observable , Subscription} from 'rxjs';

//we can now access environment.apiUrl
const API_URL = environment.apiUrl;


@Injectable({
  providedIn: 'root'
})
export class EnviamentsService {

 constructor(private http: HttpClient) { 
	alert("construim EnviamentService");
	}
  
  private handleError (error: HttpErrorResponse) {
      console.error('ApiService::handleError', error);
      return Observable.throw(error);
    }
  
  
  public getAllEnviaments(): Observable<Enviament[]> {
	alert("EnviamentsService::getAllEnviaments : " + API_URL + '/enviaments/');
	  return this.http
        .get<Enviament[]>(API_URL + '/enviaments/', {responseType: 'json'})
        .map(response => {
          const enviaments = response;
          return enviaments.map((enviament) => new Enviament(enviament));
        })
        .catch(this.handleError);

    }


    public createEnviament2(enviament: Enviament): Observable<Enviament> {
	alert("EnviamentsService::createEnviament :  " + API_URL + '/enviaments/add' + ' COMANDAID : ' + enviament.comandaId);
      return this.http
        .post(API_URL + '/enviaments/add/', enviament)
        .map(response => {
          return new Enviament(response);
        })
        .catch(this.handleError);
    }




public createEnviament(enviament: Enviament) {
    //console.log("sending message:" + this.message);
alert("createEnviament");
    this.http
      .post(API_URL + '/enviaments/add/', enviament)
      .subscribe({
        next: (data) => console.log(data),
        error: (error) => console.log(error),
        complete: () => {
          console.log('complete');
          ////this.enviament = '';
        }
      });

}






  // API: GET /enviaments/:id
  public getEnviamentById(enviamentId: number): Observable<Enviament> {
      return this.http
        .get(API_URL + '/enviaments/' + enviamentId)
        .map(response => {
          return new Enviament(response);
        })
        .catch(this.handleError);
    }

  // API: PUT /enviaments/:id
  public updateEnviament(enviament: Enviament): Observable<Enviament> {
      return this.http
        .put(API_URL + '/enviaments/add' + enviament.enviamentId, enviament)
        .map(response => {
          return new Enviament(response);
        })
        .catch(this.handleError);
    }

  // DELETE /enviaments/:id
  public deleteEnviamentById(enviamentId: number): Observable<null> {
      return this.http
        .delete(API_URL + '/enviaments/' + enviamentId)
        .map(response => null)
        .catch(this.handleError);
    }
}
