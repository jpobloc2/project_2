import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeniedReimbsComponent } from './denied-reimbs.component';

describe('DeniedReimbsComponent', () => {
  let component: DeniedReimbsComponent;
  let fixture: ComponentFixture<DeniedReimbsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeniedReimbsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeniedReimbsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
