import { Component, OnInit } from '@angular/core';
import {Country} from "../../models/country";
import {BehaviorSubject, Observable, Subscription} from "rxjs";
import {CountriesService} from "../../services/countries.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit {

  countries : Subscription;
  countriesList : Country[] = [];

  constructor(private countryService: CountriesService, private router: Router) {
    this.countries = countryService.getAllCountries().subscribe(countries => {
      this.countriesList = countries;
    });
  }

  ngOnInit(): void { this.reloadData(); }

  reloadData() { this.countries = this.countryService.getAllCountries().subscribe(countries => this.countriesList = countries); }

  onSelect(country: Country) {
    let countryId = country.id;
  }
}
