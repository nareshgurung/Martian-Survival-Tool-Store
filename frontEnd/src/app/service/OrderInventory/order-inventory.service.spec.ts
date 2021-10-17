import { TestBed } from '@angular/core/testing';

import { OrderInventoryService } from './order-inventory.service';

describe('OrderInventoryService', () => {
  let service: OrderInventoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderInventoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
