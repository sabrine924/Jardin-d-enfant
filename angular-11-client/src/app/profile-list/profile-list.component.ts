import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Profile } from '../Profile';
import { ProfileService } from '../Profile.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-profile-list',
  templateUrl: './profile-list.component.html',
  styleUrls: ['./profile-list.component.css']
})
export class ProfileListComponent implements OnInit {
  profiles!: Profile[];
  constructor(private token: TokenStorageService,private profileService: ProfileService,
    private router: Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getProfiles();
  }
  private getProfiles(){
    this.profileService.getProfilesList().subscribe(data => {
      this.profiles = data;
    });
  }

}
