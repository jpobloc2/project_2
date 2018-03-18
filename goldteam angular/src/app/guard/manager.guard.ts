import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Injectable()
export class ManagerGuard implements CanActivate {

  constructor(private cookie: CookieService, private router: Router) { }
  ck;
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
     this.ck = this.cookie.getObject('user');
      if (this.ck.roleId === 1) {
        return true;
      } else {
        this.router.navigateByUrl('/home');
      }


  }
}
