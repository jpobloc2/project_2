import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeUserComponent } from './make-user.component';

describe('MakeUserComponent', () => {
  let component: MakeUserComponent;
  let fixture: ComponentFixture<MakeUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
