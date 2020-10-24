import { DataService } from './../data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-neo',
  templateUrl: './neo.component.html',
  styleUrls: ['./neo.component.scss']
})
export class NeoComponent implements OnInit {

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.dataService.getNeo().subscribe(data =>
      console.log(data));
  }

}
