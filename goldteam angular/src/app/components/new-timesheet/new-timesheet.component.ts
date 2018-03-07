import { Component, OnInit } from '@angular/core';
import { IMyDpOptions, IMyDateModel, IMyDayLabels } from 'angular4-datepicker/src/my-date-picker';

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

    year: this.model.date.year,
    month: this.model.date.month,
    day: this.model.date.day,
    monday: 0,
    tuesday: 0,
    wednesday: 0,
    thursday: 0,
    friday: 0,

  };

  constructor() { }

  ngOnInit() {
  }

  submitTimesheet() {

   console.log(this.fullSheet);

  }

}
