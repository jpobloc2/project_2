import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { Router } from '@angular/router';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';

@Component({
  selector: 'app-create-reimb',
  templateUrl: './create-reimb.component.html',
  styleUrls: ['./create-reimb.component.css']
})
export class CreateReimbComponent implements OnInit {

  header = new HttpHeaders({ xtoken: `${localStorage.getItem('token')}` });

  reimbursement = {
    reimbAmount: 0,
    reimbType: '',
    reimbDescription: '',
    reimbAuthor: {
      userId: 0
    },
    reimbStatus: {
      status: 'Pending'
    }
  };

  ck;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router, private reimbService: ReimburseService
  ) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
  }

  submitReimbursement() {
    if (this.reimbursement.reimbAmount < 0) {
      alert('Amount must be greater than zero');
    } else if (this.reimbursement.reimbDescription === '') {
      alert('Description cannot be left empty!');
    } else {

      this.reimbursement.reimbAuthor.userId = this.ck.uId;
      console.log(this.reimbursement);
      this.reimbService.submitReimb(this.reimbursement);
      /*       this.client.post('http://localhost:8080/reimb/submit', this.reimbursement, {headers: this.header})
              .subscribe(
                (succ) => {
                  alert('submit successful');
                  console.log(succ);
                  this.router.navigateByUrl('reimbs/pending');
                },
                (err) => {
                  alert('failed to submit reimbursement');
                }

              ); */

    }
  }

}
