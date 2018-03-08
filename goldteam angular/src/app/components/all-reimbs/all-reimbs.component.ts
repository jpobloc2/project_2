import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-all-reimbs',
  templateUrl: './all-reimbs.component.html',
  styleUrls: ['./all-reimbs.component.css']
})
export class AllReimbsComponent implements OnInit {

  // reimbs: Array<Reimbursement> = [];
  // newReimb = new Reimbursement();

  reimbs: any = [];

  constructor(private reimbService: ReimburseService, private client: HttpClient) { }

  ngOnInit() {
    // this.reimbs = this.reimbService.getReimbs();
    this.client.get('http://localhost:8080/reimb/all')
    .subscribe(
      (succ: Array<Reimbursement>) => {
        this.reimbs = succ;
        console.log(succ);
        return this.reimbs;
      },
      err => {
        alert('failed to retrieve reimbursements');
      }

    );

  }


}
