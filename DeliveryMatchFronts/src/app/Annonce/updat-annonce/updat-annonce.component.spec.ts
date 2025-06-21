import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatAnnonceComponent } from './updat-annonce.component';

describe('UpdatAnnonceComponent', () => {
  let component: UpdatAnnonceComponent;
  let fixture: ComponentFixture<UpdatAnnonceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdatAnnonceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatAnnonceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
