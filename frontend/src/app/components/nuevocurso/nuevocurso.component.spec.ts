import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevocursoComponent } from './nuevocurso.component';

describe('NuevocursoComponent', () => {
  let component: NuevocursoComponent;
  let fixture: ComponentFixture<NuevocursoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevocursoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevocursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
