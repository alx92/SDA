import { DataService } from './../data.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subject, throwError } from 'rxjs';
import { catchError, retry, takeUntil } from 'rxjs/operators';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-apod',
  templateUrl: './apod.component.html',
  styleUrls: ['./apod.component.scss']
})
export class ApodComponent implements OnInit {

  constructor(private dataService: DataService) {}

  apod: any = {};

  onSubmit($event) {
    console.log($event.target.value);
    this.dataService.getApodByDate($event.target.value).subscribe((apod: any) => {
      this.apod = apod;
    });
  }

  getApod() {
  this.dataService.getApod().subscribe((apod: any) => {
    this.apod = apod;
  });
  }

  ngOnInit() {
    this.getApod();
  }
}
