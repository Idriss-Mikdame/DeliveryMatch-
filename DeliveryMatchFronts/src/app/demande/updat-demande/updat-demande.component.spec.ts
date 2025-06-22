import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatDemandeComponent } from './updat-demande.component';

describe('UpdatDemandeComponent', () => {
  let component: UpdatDemandeComponent;
  let fixture: ComponentFixture<UpdatDemandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdatDemandeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatDemandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
