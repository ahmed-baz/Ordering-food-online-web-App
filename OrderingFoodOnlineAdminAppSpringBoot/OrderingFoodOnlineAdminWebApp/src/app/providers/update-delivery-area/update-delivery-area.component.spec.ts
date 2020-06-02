import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDeliveryAreaComponent } from './update-delivery-area.component';

describe('UpdateDeliveryAreaComponent', () => {
  let component: UpdateDeliveryAreaComponent;
  let fixture: ComponentFixture<UpdateDeliveryAreaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateDeliveryAreaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDeliveryAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
