import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingReimbsComponent } from './pending-reimbs.component';

describe('PendingReimbsComponent', () => {
  let component: PendingReimbsComponent;
  let fixture: ComponentFixture<PendingReimbsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingReimbsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingReimbsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
