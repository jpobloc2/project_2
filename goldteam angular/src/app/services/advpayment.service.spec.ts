import { TestBed, inject } from '@angular/core/testing';

import { AdvpaymentService } from './advpayment.service';

describe('AdvpaymentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdvpaymentService]
    });
  });

  it('should be created', inject([AdvpaymentService], (service: AdvpaymentService) => {
    expect(service).toBeTruthy();
  }));
});
