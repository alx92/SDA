import { Component, OnInit } from '@angular/core';
import {} from 'googlemaps';
import { ViewChild } from '@angular/core';
import { DataService } from '../data.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  @ViewChild('map') mapElement: any;
  map: google.maps.Map;

  constructor(private dataService: DataService) { }

  getIssLoc() {
    return this.dataService.getIssLocation().subscribe((data: any) => {
      const loc = new google.maps.LatLng(+data.iss_position.latitude, +data.iss_position.longitude);
      const mapProperties = {
        center: loc,
        zoom: 4,
        mapTypeId: google.maps.MapTypeId.TERRAIN
      };
      this.map = new google.maps.Map(this.mapElement.nativeElement, mapProperties);
      const marker = new google.maps.Marker({
        position: loc,
      });
      marker.setMap(this.map);
    });
  }

  ngOnInit(): void {
    this.getIssLoc();
 }

}
