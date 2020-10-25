import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ApodComponent } from './apod/apod.component';
import { NeoComponent } from './neo/neo.component';
import { InsightComponent } from './insight/insight.component';
import { DatePipe } from '@angular/common';

const appRoutes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'apod', component: ApodComponent },
  { path: 'neo', component: NeoComponent },
  { path: 'insight', component: InsightComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ApodComponent,
    NeoComponent,
    InsightComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
