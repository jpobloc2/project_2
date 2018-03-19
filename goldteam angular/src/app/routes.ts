import { Routes } from '@angular/router';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { ReimbsComponent } from './components/reimbs/reimbs.component';
import { AllReimbsComponent } from './components/all-reimbs/all-reimbs.component';
import { PendingReimbsComponent } from './components/pending-reimbs/pending-reimbs.component';
import { ApprovedReimbsComponent } from './components/approved-reimbs/approved-reimbs.component';
import { DeniedReimbsComponent } from './components/denied-reimbs/denied-reimbs.component';
import { LoginComponent } from './components/login/login.component';
import { CreateReimbComponent } from './components/create-reimb/create-reimb.component';
import { HomeComponent } from './components/home/home.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { LoggedInGuard } from './guard/logged-in.guard';
import { TimesheetsComponent } from './components/timesheets/timesheets.component';
import { NewTimesheetComponent } from './components/new-timesheet/new-timesheet.component';
import { AdvancepaymentComponent } from './components/advancepayment/advancepayment.component';
import { ManagerComponent } from './components/manager/manager.component';
import { ViewUserComponent } from './components/view-user/view-user.component';
import { ViewMeComponent } from './components/view-me/view-me.component';
import { ForgotPassComponent } from './components/forgot-pass/forgot-pass.component';
import { PassResetComponent } from './components/pass-reset/pass-reset.component';
import { ManagerGuard } from './guard/manager.guard';

export const appRoutes: Routes = [
  {
    path: 'reimb',
    component: ReimbursementComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'forgot',
    component: ForgotPassComponent
  },
  {
    path: 'manager',
    component: ManagerComponent,
    canActivate: [
      LoggedInGuard,
      ManagerGuard
    ],
  },
  {
    path: 'view-user',
    component: ViewUserComponent,
    canActivate: [
      LoggedInGuard,
      ManagerGuard
    ]
  },
  {
    path: 'account-info',
    component: ViewMeComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'changePass',
    component: PassResetComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'timesheet',
    component: TimesheetsComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'new-timesheet',
    component: NewTimesheetComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'advance',
    component: AdvancepaymentComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'new-reimbursement',
    component: CreateReimbComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [
      LoggedInGuard
    ],
  },
  {
    path: 'welcome',
    component: WelcomeComponent,
    canActivate: [
      LoggedInGuard
    ],
  },
  {
    path: 'reimbs',
    component: ReimbsComponent,
    canActivate: [
      LoggedInGuard
    ],
    children: [
      {
        path: 'all',
        component: AllReimbsComponent
      },
      {
        path: 'pending',
        component: PendingReimbsComponent
      },
      {
        path: 'approved',
        component: ApprovedReimbsComponent
      },
      {
        path: 'denied',
        component: DeniedReimbsComponent
      }
    ]
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: 'login'
  }

];
