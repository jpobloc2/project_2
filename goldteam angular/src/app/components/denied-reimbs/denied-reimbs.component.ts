import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-denied-reimbs',
  templateUrl: './denied-reimbs.component.html',
  styleUrls: ['./denied-reimbs.component.css']
})
export class DeniedReimbsComponent implements OnInit {
  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});

  reimbs: any = [];
  ck;

  constructor(private reimbService: ReimburseService, private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
    this.reimbs = this.reimbService.reimbs;
  }

}
