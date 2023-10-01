import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {CountriesService} from "../../services/countries.service";
import {Subscription} from "rxjs";
import {Languages} from "../../models/languages";

@Component({
  selector: 'app-country-languages',
  templateUrl: './country-languages.component.html',
  styleUrls: ['./country-languages.component.css']
})
export class CountryLanguagesComponent implements OnInit {

  @Input() countryId: string | any;
  languages : Subscription;
  spokenLanguages: Languages[] = [];

  constructor(private countriesService: CountriesService, private router: Router) {
    this.languages = this.countriesService.getCountryLanguages(this.countryId).subscribe(languages => { this.spokenLanguages = languages });
  }

  ngOnInit(): void {
    this.languages = this.countriesService.getCountryLanguages(this.countryId).subscribe(languages => { this.spokenLanguages = languages });
  }

  handleCancel() {
    this.router.navigate(["/countries"]);
  }
}
