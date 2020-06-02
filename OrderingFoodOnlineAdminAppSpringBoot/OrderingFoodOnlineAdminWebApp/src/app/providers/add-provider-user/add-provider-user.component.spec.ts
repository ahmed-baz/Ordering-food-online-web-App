import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProviderUserComponent } from './add-provider-user.component';

describe('AddProviderUserComponent', () => {
  let component: AddProviderUserComponent;
  let fixture: ComponentFixture<AddProviderUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddProviderUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddProviderUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
