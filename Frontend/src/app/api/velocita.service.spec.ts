import { TestBed } from '@angular/core/testing';

import { VelocitaService } from './velocita.service';

describe('VelocitaService', () => {
  let service: VelocitaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VelocitaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
