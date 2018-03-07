import { TestBed, inject } from '@angular/core/testing';

import { ReimburseService } from './reimburse.service';

describe('ReimburseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReimburseService]
    });
  });

  it('should be created', inject([ReimburseService], (service: ReimburseService) => {
    expect(service).toBeTruthy();
  }));
});
