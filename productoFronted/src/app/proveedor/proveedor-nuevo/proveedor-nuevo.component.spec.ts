import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProveedorNuevoComponent } from './proveedor-nuevo.component';

describe('ProveedorNuevoComponent', () => {
  let component: ProveedorNuevoComponent;
  let fixture: ComponentFixture<ProveedorNuevoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProveedorNuevoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProveedorNuevoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
