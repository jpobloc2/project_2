import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllReimbsComponent } from './all-reimbs.component';

describe('AllReimbsComponent', () => {
  let component: AllReimbsComponent;
  let fixture: ComponentFixture<AllReimbsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllReimbsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllReimbsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
