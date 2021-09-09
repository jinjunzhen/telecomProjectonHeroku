import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Account from '../models/Account';
import Phone from '../models/Phone';
import Plan from '../models/Plan';
import { TelecomService } from '../telecom.service';
import { TokenStorageService } from '../token-storage.service';

@Component({
  selector: 'app-account-detail',
  templateUrl: './account-detail.component.html',
  styleUrls: ['./account-detail.component.css']
})
export class AccountDetailComponent implements OnInit {
  account!: Account;
  planlist!: Plan[];
  phone!: Phone;
  sum = 0;
  

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tokenStorage: TokenStorageService,
    private service: TelecomService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    const userJson = localStorage.getItem('user'); 
    this.account = userJson !== null ? JSON.parse(userJson) : new Account(); 

    this.service.fetchAccountById(this.account.account_id).subscribe( (data)=> {
      this.account = data;
      this.planlist = this.account.plans;

      for (let onePlan of this.planlist) {
        if (onePlan.plan_type === "a") {
          this.sum += (25 * onePlan.phones.length);
        }
        if (onePlan.plan_type === "b") {
          this.sum += (35 * onePlan.phones.length);
        }
        if (onePlan.plan_type === "c") {
          this.sum += (45 * onePlan.phones.length);
        }
      }
      
    },
    err => {

    });
  }

  showAppPlan() : void {}

}
