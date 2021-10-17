import { TestBed } from '@angular/core/testing';

import { PurchaseGroupsService } from './purchase-groups.service';

describe('PurchaseGroupsService', () => {
  let service: PurchaseGroupsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PurchaseGroupsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
