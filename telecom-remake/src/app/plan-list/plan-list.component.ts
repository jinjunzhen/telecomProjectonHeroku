import { Component, Input, OnInit } from '@angular/core';
import Account from '../models/Account';
import Plan from '../models/Plan';

@Component({
  selector: 'app-plan-list',
  templateUrl: './plan-list.component.html',
  styleUrls: ['./plan-list.component.css']
})
export class PlanListComponent implements OnInit {
  accountInPL! :Account;



  constructor() { }

  ngOnInit(): void {

  }

}
