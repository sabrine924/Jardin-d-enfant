import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostlistadminComponent } from './postlistadmin.component';

describe('PostlistadminComponent', () => {
  let component: PostlistadminComponent;
  let fixture: ComponentFixture<PostlistadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostlistadminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostlistadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
