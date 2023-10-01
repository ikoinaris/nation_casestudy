import { Component, OnInit } from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {Country} from "../../models/country";
import {CountriesService} from "../../services/countries.service";
import {Router} from "@angular/router";
import {Stats} from "../../models/stats";
import {CountryStatsService} from "../../services/country-stats.service";
import {CountryStats} from "../../models/country-stats";

@Component({
  selector: 'app-country-stats',
  templateUrl: './country-stats.component.html',
  styleUrls: ['./country-stats.component.css']
})
export class CountryStatsComponent implements OnInit {

  countries : Subscription;
  countriesList: Country[] = [];
  statsList: Stats[] = [];
  countryStatsList: CountryStats[] = [];
  stats: Subscription;
  displayedColumns: string[] = ['name', 'country_code3', 'year', 'population', 'gdp'];

  constructor(private countryService: CountriesService, private countryStatsService: CountryStatsService, private router: Router) {
    this.stats = countryStatsService.getAllCountryStats().subscribe(stats => this.statsList = stats);
    this.countries = countryService.getAllCountries().subscribe(countries => this.countriesList = countries);
  }

  ngOnInit(): void { this.reloadData(); }

  reloadData() {
    this.countries = this.countryService.getAllCountries().subscribe(countries => this.countriesList = countries);
    this.stats = this.countryStatsService.getAllCountryStats().subscribe(stats => this.statsList = stats);

  }

}
