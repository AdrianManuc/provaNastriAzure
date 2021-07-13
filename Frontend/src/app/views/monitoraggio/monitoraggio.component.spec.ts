import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonitoraggioComponent } from './monitoraggio.component';

describe('MonitoraggioComponent', () => {
  let component: MonitoraggioComponent;
  let fixture: ComponentFixture<MonitoraggioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonitoraggioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonitoraggioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
