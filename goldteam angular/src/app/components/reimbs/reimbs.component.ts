import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-reimbs',
  templateUrl: './reimbs.component.html',
  styleUrls: ['./reimbs.component.css']
})
export class ReimbsComponent implements OnInit {

  reimbs: Array<Reimbursement> = [];
  // newReimb = new Reimbursement();

  constructor(private reimbService: ReimburseService, private client: HttpClient) { }

  ngOnInit() {
     this.reimbs = this.reimbService.getReimbs();
  }

//   getReimbs() {
//     this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/all')
//     .subscribe(
//       succ => {
//         this.reimbs = succ;
//         return this.reimbs;
//       },
//       err => {
//         alert('failed to retrieve reimbursemnets');
//       }

//     );
// }

// }
}
