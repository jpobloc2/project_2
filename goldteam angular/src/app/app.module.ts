import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MyDatePickerModule, MyDatePicker } from 'angular4-datepicker/src/my-date-picker';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';

import { appRoutes } from './routes';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { ReimbsComponent } from './components/reimbs/reimbs.component';

import { ReimburseService } from './services/reimburse.service';
import { AllReimbsComponent } from './components/all-reimbs/all-reimbs.component';
import { PendingReimbsComponent } from './components/pending-reimbs/pending-reimbs.component';
import { ApprovedReimbsComponent } from './components/approved-reimbs/approved-reimbs.component';
import { DeniedReimbsComponent } from './components/denied-reimbs/denied-reimbs.component';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { LoginComponent } from './components/login/login.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CreateReimbComponent } from './components/create-reimb/create-reimb.component';
import { HomeComponent } from './components/home/home.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { LoggedInGuard } from './guard/logged-in.guard';
import { FooterComponent } from './components/footer/footer.component';
import { TypePipePipe } from './pipes/type-pipe.pipe';
import { TimesheetsComponent } from './components/timesheets/timesheets.component';
import { NewTimesheetComponent } from './components/new-timesheet/new-timesheet.component';
import { AdvancepaymentComponent } from './components/advancepayment/advancepayment.component';


@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule,
    MyDatePickerModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    ReimbursementComponent,
    ReimbsComponent,
    AllReimbsComponent,
    PendingReimbsComponent,
    ApprovedReimbsComponent,
    DeniedReimbsComponent,
    LoginComponent,
    CreateReimbComponent,
    HomeComponent,
    WelcomeComponent,
    FooterComponent,
    TypePipePipe,
    TimesheetsComponent,
    NewTimesheetComponent,
    AdvancepaymentComponent
  ],
  providers: [
    ReimburseService,
    CookieService,
  LoggedInGuard],
  bootstrap: [AppComponent,
  NewTimesheetComponent]
})
export class AppModule { }
