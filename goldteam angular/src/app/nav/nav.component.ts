import { Component, OnInit } from '@angular/core';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  ck;

  constructor(private cookie: CookieService, private userService: UserServiceService) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
  }

  logOut() {
  }

}
