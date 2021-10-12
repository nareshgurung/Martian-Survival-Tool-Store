import { TestBed } from '@angular/core/testing';

import { GroupContentsService } from './group-contents.service';

describe('GroupContentsService', () => {
  let service: GroupContentsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GroupContentsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
