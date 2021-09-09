import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Phone from '../models/Phone';
import Plan from '../models/Plan';
import { TelecomService } from '../telecom.service';
import { TokenStorageService } from '../token-storage.service';

@Component({
  selector: 'app-plan-detail',
  templateUrl: './plan-detail.component.html',
  styleUrls: ['./plan-detail.component.css']
})
export class PlanDetailComponent implements OnInit {
  @Input() onePlan!: Plan;
  onePhone!: Phone;
  addPhoneBox!:boolean;
  // phoneUpdate!: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tokenStorage: TokenStorageService,
    private service: TelecomService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.addPhoneBox = false;
  }

  showAddDevice(): void { 
    this.addPhoneBox = !this.addPhoneBox;
  }


  editPhone(): void {

  }


  deletePlan(): void {
    this.service.deletePlan(this.onePlan.plan_id).subscribe((data) => {
      this.router.navigate(['/home']).then(() => {
        parent.location.reload();
      });
    },
      err => {
      });
  }

  deletePhone(phone_id: number): void {
    this.service.deletePhone(phone_id).subscribe((data)=> {
      this.router.navigate(['/home']).then(() => {
        parent.location.reload();
      });

    },
    err => {

    });

  }


  reloadPage(): void {
    window.location.reload();
  }

}
