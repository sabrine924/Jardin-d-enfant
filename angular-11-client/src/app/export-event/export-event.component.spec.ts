import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExportEventComponent } from './export-event.component';

describe('ExportEventComponent', () => {
  let component: ExportEventComponent;
  let fixture: ComponentFixture<ExportEventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExportEventComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
