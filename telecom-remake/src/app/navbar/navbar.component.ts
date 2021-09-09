import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Emitters } from '../emitters/emitters';
import { TokenStorageService } from '../token-storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  private roles: string[] = [];
  isLoggedIn = false;
  auththticated = false;
  title = 'authSampleJjz';
  username?: string;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tokenStorageService: TokenStorageService,
  ) { }



  ngOnInit(): void { 
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    Emitters.authEmitter.subscribe((auth: boolean)=> {
      this.auththticated = auth;
    });

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.username = user.username;
    }
  }

  logout(): void {
    
    this.tokenStorageService.signOut();
    this.auththticated = false;
    this.reloadPage();
  }

    reloadPage(): void {
    window.location.reload();
  }

}