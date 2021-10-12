import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupContentsComponent } from './group-contents.component';

describe('GroupContentsComponent', () => {
  let component: GroupContentsComponent;
  let fixture: ComponentFixture<GroupContentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GroupContentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupContentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
