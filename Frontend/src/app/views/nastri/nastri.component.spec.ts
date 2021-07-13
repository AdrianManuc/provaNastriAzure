import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NastriComponent } from './nastri.component';

describe('NastriComponent', () => {
  let component: NastriComponent;
  let fixture: ComponentFixture<NastriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NastriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NastriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
