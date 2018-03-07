import { Pipe, PipeTransform } from '@angular/core';
import { Reimbursement } from '../beans/reimbursement';

@Pipe({
  name: 'typePipe'
})
export class TypePipePipe implements PipeTransform {

  transform(reimbursement: Reimbursement): any {
    if (reimbursement.type === 0) {
      return 'Lodging';
    }
    if (reimbursement.type === 1) {
      return 'Travel';
    }
    if (reimbursement.type === 2) {
      return 'Food';
    }
    if (reimbursement.type === 3) {
      return 'Other';
    }
    return null;
  }

}
