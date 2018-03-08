import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-timesheets',
  templateUrl: './timesheets.component.html',
  styleUrls: ['./timesheets.component.css']
})
export class TimesheetsComponent implements OnInit {

  sheets: any = [];

  constructor(private client: HttpClient) { }

  ngOnInit() {

    this.client.get('http://localhost:8080/timesheet/all')
    .subscribe(
      succ => {
        this.sheets = succ;
        console.log(succ);
        return this.sheets;

      }, err => {
        alert('failed to retrieve timesheets');
      }

    );
  }

}
