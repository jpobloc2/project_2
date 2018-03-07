import { Component, OnInit, Input } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {
  @Input()
  reimbs: Reimbursement;
  // reimbs: Array<Reimbursement> = [];


constructor(private reimbService: ReimburseService, private client: HttpClient) { }

ngOnInit() {
}

}
