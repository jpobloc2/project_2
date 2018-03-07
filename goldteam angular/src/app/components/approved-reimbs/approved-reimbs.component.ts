import { Component, OnInit } from '@angular/core';
import { ReimburseService } from '../../services/reimburse.service';
import { Reimbursement } from '../../beans/reimbursement';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-approved-reimbs',
  templateUrl: './approved-reimbs.component.html',
  styleUrls: ['./approved-reimbs.component.css']
})
export class ApprovedReimbsComponent implements OnInit {
  reimbs: Array<Reimbursement> = [];
  // newReimb = new Reimbursement();


  constructor(private reimbService: ReimburseService, private client: HttpClient) { }

  ngOnInit() {
    // this.reimbs = this.reimbService.getReimbs();

    this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/all', { withCredentials: true })
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
