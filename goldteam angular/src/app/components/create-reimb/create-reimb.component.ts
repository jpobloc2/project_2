import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { Router } from '@angular/router';
import { Reimbursement } from '../../beans/reimbursement';

@Component({
  selector: 'app-create-reimb',
  templateUrl: './create-reimb.component.html',
  styleUrls: ['./create-reimb.component.css']
})
export class CreateReimbComponent implements OnInit {

  reimbursement = {
    amount: 0,
    description: '',
    type: Number
  };


  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
  }

  submitReimbursement() {
    if (this.reimbursement.amount < 0) {
      alert('Amount must be greater than zero');
    } else if (this.reimbursement.description === '') {
      alert('Description cannot be left empty!');
    } else {


      this.client.post('http://localhost:8080/Reimbursement-System/reimbursement', this.reimbursement,
        { withCredentials: true })
        .subscribe(
          (succ) => {
            alert('submit successful');
            this.router.navigateByUrl('reimbs/pending');
          },
          (err) => {
            alert('failed to submit reimbursement');
          }


        );

    }
  }

}
