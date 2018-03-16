import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class TimesheetService {

  constructor(private client: HttpClient) { }

   header;

  obv: Subject<any> = new Subject;

  getSheets(): any {
    this.header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
    this.client.get('http://localhost:8080/timesheet/', {headers: this.header})
    .subscribe(
      succ => {
        console.log(succ);
        this.obv.next(succ);
      }, err => {
        alert('failed to retrieve all timesheets');
      }

    );
  }

}
