import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProviderUserListComponent } from './provider-user-list.component';

describe('ProviderUserListComponent', () => {
  let component: ProviderUserListComponent;
  let fixture: ComponentFixture<ProviderUserListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProviderUserListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProviderUserListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
