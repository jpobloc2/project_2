import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Http } from '@angular/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {
    username: '',
    password: ''
  };

  user: any = [];

  ck: any = {
    uId: null,
    firstName: null,
    roleId: null
  };

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.client.post('http://localhost:8080/users', this.credentials,
      )
      .subscribe(
        (succ: any) => {
          alert(this.credentials.username +  ` has logged in`);
          this.user = succ;
          this.ck.uId = succ.userId;
          this.ck.firstName = succ.firstName;
          this.ck.roleId = succ.role.userRoleId;
          this.cookie.putObject('user', this.ck);
          this.router.navigateByUrl('home');
          console.log(succ);
          console.log(this.ck);
          console.log(this.cookie);
        },
        (err) => {
          alert('failed to log in');
        }
      );

  }
}
