import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AccountDetailComponent } from './account-detail/account-detail.component';
import { PlanDetailComponent } from './plan-detail/plan-detail.component';
import { PhoneDetailComponent } from './phone-detail/phone-detail.component';
import { AddPlanComponent } from './add-plan/add-plan.component';
import { AddPhoneComponent } from './add-phone/add-phone.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FrontPageComponent } from './front-page/front-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { EditDeviceComponent } from './edit-device/edit-device.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    AccountDetailComponent,
    PlanDetailComponent,
    PhoneDetailComponent,
    AddPlanComponent,
    AddPhoneComponent,
    FrontPageComponent,
    NavbarComponent,
    EditDeviceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
