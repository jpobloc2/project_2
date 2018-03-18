import { Component, OnInit } from '@angular/core';
import { ReimburseService } from '../../services/reimburse.service';
import { Reimbursement } from '../../beans/reimbursement';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-approved-reimbs',
  templateUrl: './approved-reimbs.component.html',
  styleUrls: ['./approved-reimbs.component.css']
})
export class ApprovedReimbsComponent implements OnInit {

  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
  reimbs: any = [];
  ck;



  constructor(private reimbService: ReimburseService, private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
    this.reimbs = this.reimbService.reimbs;
  }

}
