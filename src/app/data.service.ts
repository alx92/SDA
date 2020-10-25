import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({ providedIn: 'root' })
export class DataService {

  constructor(private http: HttpClient) { }

  rootUrl = '/api';

  key = 'F2t9eSuecY54NKs8RH7PZ97xdeFXfg6M4A81sVbF';

  // startDate = '2020-09-09';

  // endDate = '2020-09-09';

  neoUrl = 'https://api.nasa.gov/neo/rest/v1/feed?start_date=';


  getNeo(startDate: string, endDate: string){
    return this.http.get(this.neoUrl + startDate + '&end_date=' +
    endDate + '&api_key=' + this.key);
  }

  getAllNeos() {
    return this.http.get(this.neoUrl);
  }

  getApod() {
    return this.http.get(this.rootUrl + '/apod/');
  }

  getApodByDate(apodDate: string) {
    return this.http.get(this.rootUrl + '/apod/' + apodDate);
  }

  getApods() {
    return this.http.get(this.rootUrl + '/apods');
  }
}
