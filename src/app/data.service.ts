import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class DataService {

  constructor(private http: HttpClient) { }

  rootUrl = '/api';

  key = 'F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF';

  neoUrl = 'https://api.nasa.gov/neo/rest/v1/feed?start_date=';

  issUrl = 'http://api.open-notify.org/iss-now.json';

  // ISS

  getIssLocation() {
    return this.http.get(this.issUrl);
  }

  // NeoWs

  getNeo(startDate: string, endDate: string) {
    return this.http.get(this.neoUrl + startDate + '&end_date=' + endDate + '&api_key=' + this.key);
  }

  // APOD

  getApod() {
    return this.http.get(this.rootUrl + '/apod');
  }

  getApodByDate(apodDate: string) {
    return this.http.get(this.rootUrl + '/apod/' + apodDate);
  }
}
