import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioNastroComponent } from './dettaglio-nastro.component';

describe('DettaglioNastroComponent', () => {
  let component: DettaglioNastroComponent;
  let fixture: ComponentFixture<DettaglioNastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DettaglioNastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioNastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
