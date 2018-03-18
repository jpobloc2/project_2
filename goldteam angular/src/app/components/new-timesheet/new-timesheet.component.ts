import { Component, OnInit } from '@angular/core';
import { IMyDpOptions, IMyDateModel, IMyDayLabels } from 'angular4-datepicker/src/my-date-picker';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-timesheet',
  templateUrl: './new-timesheet.component.html',
  styleUrls: ['./new-timesheet.component.css']
})
export class NewTimesheetComponent implements OnInit {

  header = new HttpHeaders({ xtoken: `${localStorage.getItem('token')}` });


  public myDatePickerOptions: IMyDpOptions = {
    firstDayOfWeek: 'mon',
    dayLabels: { su: 'Sun', mo: 'Mon', tu: 'Tue', we: 'Wed', th: 'Thu', fr: 'Fri', sa: 'Sat' },
    markCurrentDay: true,
    editableDateField: false,
    sunHighlight: true,
    inline: false,
    disableWeekends: true,
    disableWeekdays: ['tu', 'we', 'th', 'fr'],
    dateFormat: 'mm.dd.yyyy',
  };


  public model: any = { date: { year: 2018, month: 3, day: 3 } };
  sDate = JSON.stringify(this.model.date);
  sDate2 = new Date().toLocaleDateString;
  sDate3;



  fullSheet = {


    startDate: this.sDate3,
    // startDate : `${this.model.date.year}-${this.model.date.month}-${this.model.date.day}`,
    // year: this.model.date.year,
    // month: this.model.date.month,
    // day: this.model.date.day,
    monday: 0,
    tuesday: 0,
    wednesday: 0,
    thursday: 0,
    friday: 0,
    hoursTotal: 0,

    author: {
      userId: 0
    },
    status: {
      status: 'Pending'
    },
    tsComment: ''

  };

  ck;


  constructor(private cookie: CookieService, private client: HttpClient, private router: Router) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
  }

  submitTimesheet() {

    this.fullSheet.hoursTotal = this.fullSheet.monday + this.fullSheet.tuesday + this.fullSheet.wednesday + this.fullSheet.thursday + this.fullSheet.friday;
    this.fullSheet.author.userId = this.ck.uId;
    this.sDate = JSON.stringify(this.model.date);
    this.sDate2 = new Date().toLocaleDateString;
    if (this.model.date.month < 10) {
      if (this.model.date.day < 10) {
        this.sDate3 = `${this.model.date.year}-0${this.model.date.month}-0${this.model.date.day + 1}`;
      } else {
        this.sDate3 = `${this.model.date.year}-0${this.model.date.month}-${this.model.date.day + 1}`;
      }
    } else {
      if (this.model.date.day < 10) {
        this.sDate3 = `${this.model.date.year}-${this.model.date.month}-0${this.model.date.day + 1}`;
      } else {
        this.sDate3 = `${this.model.date.year}-${this.model.date.month}-${this.model.date.day + 1}`;
      }

    }

    this.fullSheet.startDate = this.sDate3;
    console.log(this.fullSheet);

    this.client.post('http://localhost:8080/timesheet/submit', this.fullSheet, { headers: this.header })
      .subscribe(
        succ => {
          alert('Timesheet submitted');
          console.log(succ);
        },
        err => {
          alert('Submission failed');
        }
      );

  }

}
