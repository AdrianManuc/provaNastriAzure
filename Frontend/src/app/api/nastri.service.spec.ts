import { TestBed } from '@angular/core/testing';

import { NastriService } from './nastri.service';

describe('NastriService', () => {
  let service: NastriService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NastriService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
