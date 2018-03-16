import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

import { Router } from '@angular/router';
import { TimesheetService } from '../../services/timesheet.service';


@Component({
  selector: 'app-timesheets',
  templateUrl: './timesheets.component.html',
  styleUrls: ['./timesheets.component.css']
})
export class TimesheetsComponent implements OnInit, OnDestroy {
  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
   timesheets = [];


  string = '';


  updateSheet = {
    itemId: 0,
    resolution: '',
    userId: 0

  };

  private ck;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router, private sheetService: TimesheetService) { }



  ngOnInit() {
    this.sheetService.obv.subscribe((data => {
      this.timesheets = data;
    }));
    this.ck = this.cookie.getObject('user');
    this.sheetService.getSheets();
  }

  ngOnDestroy() {
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
