import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Account from '../models/Account';
import Box from '../models/InoutForm';
import { TelecomService } from '../telecom.service';
import { TokenStorageService } from '../token-storage.service';
import * as $ from "jquery";



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isLoggedIn = false;
  roles: string[] = [];
  accountForm!: FormGroup;
  errorMessage = '';
  account!: Account;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tokenStorage: TokenStorageService,
    private service: TelecomService,
    private formBuilder: FormBuilder,
  ) { }




  ngOnInit(): void {

    

    this.accountForm = this.formBuilder.group({
      log_in_email: new FormControl("", [
        Validators.email,
        Validators.required
      ]),
      log_in_pass_word: new FormControl("", [
        Validators.minLength(2)
      ]),
    })


    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  // routeSample() {
  //   this.route.snapshot.params['id'];

  // }

  login(): void {
    this.service.logInAccount(this.accountForm.value).subscribe(data => {
      this.account = data;
      localStorage.setItem("user", JSON.stringify(this.account));
      this.tokenStorage.saveToken("token");
      this.tokenStorage.saveUser(this.account);
      this.isLoggedIn = true;
      
      
      this.router.navigate(['/home']).then(()=>{
        parent.location.reload();
      });

    }, err => {
      this.errorMessage = "account or password not correct"
    });
  }

  // fakeLogin() {
  //   const { log_in_email, log_in_pass_word } = this.account;
    
  //   if (log_in_email === "jinjunzhen@yahoo.com" && log_in_pass_word==="123456") {
  //     console.log("flow");
  //     this.isLoggedIn = true;
  //     this.tokenStorage.saveToken("token");
  //     this.tokenStorage.saveUser({
  //       "account_id" : 1,
  //       "log_in_email": "jinjunzhen@yahoo.com",
  //       "log_in_pass_word": "123456"
        
  //     });
  //     this.isLoggedIn = true;
  //     this.roles = this.tokenStorage.getUser().roles;
  //     console.log(this.roles);
  //     // this.reloadPage();

  //     localStorage.setItem("user", JSON.stringify(this.account));
      
  //     this.router.navigate(['/home']);
  //     parent.location.reload();


  //   } else {
  //     this.errorMessage = "account or password not correct"
  //   }
  // }

  reloadPage(): void {
    window.location.reload();
  }


}
