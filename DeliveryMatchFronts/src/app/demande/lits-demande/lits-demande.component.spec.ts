import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LitsDemandeComponent } from './lits-demande.component';

describe('LitsDemandeComponent', () => {
  let component: LitsDemandeComponent;
  let fixture: ComponentFixture<LitsDemandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LitsDemandeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LitsDemandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
