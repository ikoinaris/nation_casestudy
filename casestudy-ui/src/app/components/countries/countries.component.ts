import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Country} from "../../models/country";
import {Subscription} from "rxjs";
import {CountriesService} from "../../services/countries.service";
import {Router} from "@angular/router";
import {CountryLanguagesComponent} from "../country-languages/country-languages.component";

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit  {

  countryId: string = "";
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
    this.router.navigate(["/countries/" +country.id+ "/languages"])
  }
}
