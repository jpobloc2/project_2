import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvancepaymentComponent } from './advancepayment.component';

describe('AdvancepaymentComponent', () => {
  let component: AdvancepaymentComponent;
  let fixture: ComponentFixture<AdvancepaymentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvancepaymentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvancepaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
