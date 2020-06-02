import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProviderUserComponent } from './update-provider-user.component';

describe('UpdateProviderUserComponent', () => {
  let component: UpdateProviderUserComponent;
  let fixture: ComponentFixture<UpdateProviderUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateProviderUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateProviderUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
