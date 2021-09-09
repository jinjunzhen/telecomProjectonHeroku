import { Component, OnInit } from '@angular/core';
import { ChildrenOutletContexts } from '@angular/router';
import Account from '../models/Account';
import Box from '../models/InoutForm';
import InputForm from '../models/InoutForm';
import Plan from '../models/Plan';
import { TokenStorageService } from '../token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  // account!: Account;
  // planList!: Plan[];


  log_in_email!: string;
  isLoggedIn = false;
  roles: string[] = [];
  jsonString!: string;

  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (!localStorage.getItem('user')) { 
      localStorage.setItem('foo', 'no reload') 
      location.reload() 
    } else {
      localStorage.removeItem('foo') 
    }

    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }

    

    
       
  }

  reloadPage(): void {
    window.location.reload();
  }

}
