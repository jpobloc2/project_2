import { Component, OnInit } from '@angular/core';
import { IMyDpOptions, IMyDateModel, IMyDayLabels } from 'angular4-datepicker/src/my-date-picker';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-timesheet',
  templateUrl: './new-timesheet.component.html',
  styleUrls: ['./new-timesheet.component.css']
})
export class NewTimesheetComponent implements OnInit {




  public myDatePickerOptions: IMyDpOptions = {
    firstDayOfWeek: 'mon',
    dayLabels: {su: 'Sun', mo: 'Mon', tu: 'Tue', we: 'Wed', th: 'Thu', fr: 'Fri', sa: 'Sat'},
    markCurrentDay: true,
    editableDateField: false,
    sunHighlight: true,
    inline: false,
    disableWeekends: true,
    dateFormat: 'mm.dd.yyyy',
  };


  public model: any = { date: { year: 2018, month: 3, day: 1 } };



  fullSheet = {


    // startDate: this.model.dateFormat,
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
   console.log(this.fullSheet);

   this.client.post('http://localhost:8080/timesheet/submit', this.fullSheet)
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
