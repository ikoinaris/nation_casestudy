import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CountryStatsService {

  countriesStatsUrl = 'https://localhost:8080/countries/stats';

  constructor(private http: HttpClient) { }

  public getAllCountryStats() : Observable<any> {
    return this.http.get(`${this.countriesStatsUrl}`);
  }

}
