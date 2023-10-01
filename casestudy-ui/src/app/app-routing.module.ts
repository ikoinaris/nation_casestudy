import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CountriesComponent} from "./components/countries/countries.component";
import {CountryStatsComponent} from "./components/country-stats/country-stats.component";
import {CountryLanguagesComponent} from "./components/country-languages/country-languages.component";

const routes: Routes = [
  { path: '', redirectTo: 'countries', pathMatch:'full'},
  { path: 'countries', component: CountriesComponent },
  { path: 'countries/stats', component: CountryStatsComponent },
  { path: 'countries/:id/languages', component: CountryLanguagesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
