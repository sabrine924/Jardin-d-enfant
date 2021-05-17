import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostlistnewComponent } from './postlistnew.component';

describe('PostlistnewComponent', () => {
  let component: PostlistnewComponent;
  let fixture: ComponentFixture<PostlistnewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostlistnewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostlistnewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
