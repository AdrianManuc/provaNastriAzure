import { TestBed } from '@angular/core/testing';

import { ConsumiService } from './consumi.service';

describe('ConsumiService', () => {
  let service: ConsumiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsumiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
