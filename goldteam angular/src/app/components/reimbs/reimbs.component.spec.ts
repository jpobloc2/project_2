import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbsComponent } from './reimbs.component';

describe('ReimbsComponent', () => {
  let component: ReimbsComponent;
  let fixture: ComponentFixture<ReimbsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
