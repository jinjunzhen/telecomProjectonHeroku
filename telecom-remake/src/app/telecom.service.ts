import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Account from './models/Account';
import { Observable } from 'rxjs';
import Plan from './models/Plan';
import Phone from './models/Phone';
import { environment } from 'src/environments/environment.prod';

const baseUrl = environment.baseUrl;

const phone_url = baseUrl+ 'phones/phone';
const account_url = baseUrl+ 'accounts/account';
const plan_url = baseUrl+ 'plans/plan';
const getOneAccount_url = baseUrl+ 'accounts/login';
const putPlanToAcct_url_1 = baseUrl+ 'plans/';
const putPlanToAcct_url_2 = '/addPlan/';
const test_url = baseUrl+ 'phones/2/addPhone/1';
const generateNewNumber_url = baseUrl+ 'phones/phone/generateNumber';

const putPhoneToPlan_url_1 = baseUrl + "phones/";
const putPhoneToPlan_url_2 = "/addPhone/";

@Injectable({
  providedIn: 'root'
})
export class TelecomService {

  temp_url = "";

  myAccount!: Account;

  constructor(private httpClient: HttpClient) { }

  //-------------------------------------------------------------------------------account
  findAllAccount(): Observable<Account[]> {
    return this.httpClient.get<Account[]>(account_url);
  }
  saveAccount(account: Account): Observable<Account> {
    return this.httpClient.post<Account>(account_url, account);
  }
  logInAccount(account: Account): Observable<Account> {
    return this.httpClient.post<Account>(getOneAccount_url, account);
  }
  fetchAccountById(aid: number): Observable<Account> {
    return this.httpClient.get<Account>(account_url + '/' + aid);
  }

  //-------------------------------------------------------------------------------plan
  savePlan(plan: Plan): Observable<Plan> {
    return this.httpClient.post<Plan>(plan_url, plan);
  }

  connectPlanToAcct(plan_id: number, acc_id: number): void {
    this.temp_url = putPlanToAcct_url_1 + plan_id + putPlanToAcct_url_2 + acc_id;
    // console.log(this.temp_url);
    // console.log(this.test_url);
    this.httpClient.put(this.temp_url, null).subscribe();
  }

  deletePlan(plan_id: number): Observable<any> {
    return this.httpClient.delete(plan_url + "/" + plan_id);
  }

  //-------------------------------------------------------------------------------phone   
  findAllPhone(): Observable<Phone[]> {
    return this.httpClient.get<Phone[]>(phone_url);
  }
  savePhone(phone: Phone): Observable<Phone> {
    return this.httpClient.post<Phone>(phone_url, phone);
  }

  deletePhone(phone_id: number): Observable<any> {
    return this.httpClient.delete(phone_url + "/" + phone_id);
  }

  connectPhoneToPlan(phone_id: number, plan_id: number): void {
    this.temp_url = putPhoneToPlan_url_1 + phone_id + putPhoneToPlan_url_2 + plan_id;
    console.log(this.temp_url);
    this.httpClient.put(this.temp_url, null).subscribe();
  }

  generateNewNumber(): Observable<any> {
    return this.httpClient.get<string>(generateNewNumber_url);
  }

}
