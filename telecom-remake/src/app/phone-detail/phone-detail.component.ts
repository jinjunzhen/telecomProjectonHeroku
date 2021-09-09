import { Component, Input, OnInit } from '@angular/core';
import Phone from '../models/Phone';

@Component({
  selector: 'app-phone-detail',
  templateUrl: './phone-detail.component.html',
  styleUrls: ['./phone-detail.component.css']
})
export class PhoneDetailComponent implements OnInit {
  @Input() onePhone!: Phone;

  constructor() { }

  ngOnInit(): void {
  }
  

}
