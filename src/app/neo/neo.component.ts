import { Observable, of, from } from 'rxjs';
import { DataService } from './../data.service';
import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { DatePipe } from '@angular/common';



@Component({
  selector: 'app-neo',
  templateUrl: './neo.component.html',
  styleUrls: ['./neo.component.scss']
})
export class NeoComponent implements OnInit {

  // startDate = '2020-09-09';

  // endDate = '2020-09-09';

  neo: any;
  date = new Date();
  startDate: string;
  endDate: string;

  transformDate(date: Date) {
    return this.datePipe.transform(date, 'yyyy-MM-dd');
  }


  constructor(private dataService: DataService, private datePipe: DatePipe) {}

  getNeoInit() {
    this.dataService.getNeo(this.startDate, this.endDate).subscribe((data: any) => {
      console.log(data);
      // this.neo = data.near_earth_objects[this.startDate]
      // .filter((el: any) => el.is_potentially_hazardous_asteroid);
      this.neo = data;
    });
  }

  ngOnInit(): void {
     this.startDate = this.transformDate(this.date);
     this.endDate = this.transformDate(this.date);
     this.getNeoInit();
  }

}
