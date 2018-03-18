import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMeComponent } from './view-me.component';

describe('ViewMeComponent', () => {
  let component: ViewMeComponent;
  let fixture: ComponentFixture<ViewMeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewMeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
