import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-denied-reimbs',
  templateUrl: './denied-reimbs.component.html',
  styleUrls: ['./denied-reimbs.component.css']
})
export class DeniedReimbsComponent implements OnInit {

  reimbs: Array<Reimbursement> = [];
  // newReimb = new Reimbursement();

  constructor(private reimbService: ReimburseService, private client: HttpClient) { }

  ngOnInit() {
    // this.reimbs = this.reimbService.getReimbs();
    this.client.get('http://localhost:8080/reimbs/all', { withCredentials: true })
    .subscribe(
      (succ: Array<Reimbursement>) => {
        this.reimbs = succ;
        return this.reimbs;
      },
      err => {
        alert('failed to retrieve reimbursements');
      }

    );

  }

}
