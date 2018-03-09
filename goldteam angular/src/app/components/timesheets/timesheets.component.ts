import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-timesheets',
  templateUrl: './timesheets.component.html',
  styleUrls: ['./timesheets.component.css']
})
export class TimesheetsComponent implements OnInit {
  timesheets: any = [];

  private ck;

  constructor(private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
    console.log(this.ck.roleId);
    if (this.ck.roleId === 0) {
    this.client.get(`http://localhost:8080/timesheet/${this.ck.uId}`)
    .subscribe(
      succ => {
        this.timesheets = succ;
        console.log(this.timesheets);
        return this.timesheets;
      }, err => {
        alert('failed to retrieve user timesheets');
      }
    );


    } else {
    this.client.get('http://localhost:8080/timesheet/all')
    .subscribe(
      succ => {
        this.timesheets = succ;
        console.log(succ);
        return this.timesheets;

      }, err => {
        alert('failed to retrieve all timesheets');
      }

    );
  }
  }
}
