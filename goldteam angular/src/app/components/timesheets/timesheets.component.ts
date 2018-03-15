import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

import { Router } from '@angular/router';


@Component({
  selector: 'app-timesheets',
  templateUrl: './timesheets.component.html',
  styleUrls: ['./timesheets.component.css']
})
export class TimesheetsComponent implements OnInit {
  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
  timesheets: any = [];


  string = '';


  updateSheet = {
    itemId: 0,
    resolution: '',
    userId: 0

  };

  private ck;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
    console.log(this.ck.roleId);
    this.client.get('http://localhost:8080/timesheet/', {headers: this.header})
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

  updateStatus(sheetId: number, sheetStatus: string) {
    this.updateSheet.itemId = sheetId;
    this.updateSheet.resolution = sheetStatus;
    this.updateSheet.userId = this.ck.uId;
    console.log(this.updateSheet);
    this.client.put(`http://localhost:8080/timesheet`, this.updateSheet, {headers: this.header})
      .subscribe(
        succ => {
          if (sheetStatus === 'Accepted') {
            alert('Timesheet approved');
            this.string = 'timesheet approved!';
            // this.router.navigateByUrl('timesheet');
            this.ngOnInit();
          }
          if (sheetStatus === 'Declined') {
            alert('Timesheet denied');
            this.string = 'timesheet declined!';
            // this.router.navigateByUrl('timesheet');
            this.ngOnInit();
          }
        },
        err => {
          alert('failed to update sheet status');
        }
      );


}
}
