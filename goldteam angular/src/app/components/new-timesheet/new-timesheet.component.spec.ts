import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTimesheetComponent } from './new-timesheet.component';

describe('NewTimesheetComponent', () => {
  let component: NewTimesheetComponent;
  let fixture: ComponentFixture<NewTimesheetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewTimesheetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTimesheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
