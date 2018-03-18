import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-all-reimbs',
  templateUrl: './all-reimbs.component.html',
  styleUrls: ['./all-reimbs.component.css']
})
export class AllReimbsComponent implements OnInit {

  // header = new HttpHeaders({ xtoken: `${localStorage.getItem('token')}` });


  reimbs: any = [];

  constructor(private reimbService: ReimburseService) { }
  ngOnInit() {
    this.reimbs = this.reimbService.reimbs;
    }
  }


    // this.client.get(`http://localhost:8080/reimb/`, { headers: this.header })
    //   .subscribe(
    //     (succ: Array<Reimbursement>) => {
    //       this.reimbs = succ;
    //       console.log(succ);
    //       return this.reimbs;
    //     },
    //     err => {
    //       alert('failed to retrieve reimbursements');
    //     }

    //   );





