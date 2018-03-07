import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprovedReimbsComponent } from './approved-reimbs.component';

describe('ApprovedReimbsComponent', () => {
  let component: ApprovedReimbsComponent;
  let fixture: ComponentFixture<ApprovedReimbsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApprovedReimbsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApprovedReimbsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
