import { TestBed } from '@angular/core/testing';

import { LookupsManagerService } from './lookups-manager.service';

describe('LookupsManagerService', () => {
  let service: LookupsManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LookupsManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
