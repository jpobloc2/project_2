import { Component, OnInit } from '@angular/core';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { UserServiceService } from '../services/user-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  ck;

  constructor(private cookie: CookieService, private userService: UserServiceService, private router: Router) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
  }

  logOut() {
    sessionStorage.clear();
    console.log('logging out');
    this.cookie.remove('user');
    this.cookie.removeAll();
    localStorage.clear();
    this.router.navigateByUrl('/login');
  }

}
