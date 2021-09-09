import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Account from '../models/Account';
import Plan from '../models/Plan';
import { TelecomService } from '../telecom.service';
import { TokenStorageService } from '../token-storage.service';

@Component({
  selector: 'app-add-plan',
  templateUrl: './add-plan.component.html',
  styleUrls: ['./add-plan.component.css']
})
export class AddPlanComponent implements OnInit {
  newPlan!: Plan;
  account!: Account;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tokenStorage: TokenStorageService,
    private service: TelecomService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.newPlan = new Plan();

  }

  addPlanA(): void {
    this.newPlan.plan_type = "a";
    this.addPlan();
  }

  addPlanB(): void {
    this.newPlan.plan_type = "b";
    this.addPlan();
  }

  addPlanC(): void {
    this.newPlan.plan_type = "c";
    this.addPlan();
  }

  addPlan(): void {
    this.service.savePlan(this.newPlan).subscribe((data) => {
      this.newPlan = data;

      const userJson = localStorage.getItem('user');
      this.account = userJson !== null ? JSON.parse(userJson) : new Account();

      console.log("put plan to account");
      this.service.connectPlanToAcct(this.newPlan.plan_id, this.account.account_id);
      this.router.navigate(['/home']).then(()=>{
        parent.location.reload();
      });
    },
      err => {
      });
  }




}
