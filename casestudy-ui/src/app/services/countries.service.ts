import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs";
import {Country} from "../models/country";

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  countriesUrl = 'http://localhost:8080/countries';

  constructor(private http: HttpClient) { }

  public getCountryById(id: string) : Observable<any> {
    return this.http.get(`${this.countriesUrl}/${id}`)
  }

  public getAllCountries() : Observable<any> {
    return this.http.get<Country[]>(`${this.countriesUrl}`);
  }

  public getCountryStats(id: string) : Observable<any> {
    return this.http.get(`${this.countriesUrl}/${id}/stats`)
  }

  public getCountryLanguages(id: string) : Observable<any> {
    return this.http.get(`${this.countriesUrl}/${id}/languages`)

  }

}
