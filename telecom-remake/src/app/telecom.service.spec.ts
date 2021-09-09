import { TestBed } from '@angular/core/testing';

import { TelecomService } from './telecom.service';

describe('TelecomService', () => {
  let service: TelecomService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TelecomService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
