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
  token: any;

  ck: any = {
    uId: null,
    firstName: null,
    roleId: null
  };

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.client.post('http://localhost:8080/users/login', this.credentials,
      )
      .subscribe(
        (succ: any) => {
          alert(this.credentials.username +  ` has logged in`);
          // console.log(succ);
          // console.log(succ.token);
          this.token = succ.token;
          this.user = succ.user;
          this.ck.uId = succ.user.userId;
          this.ck.firstName = succ.user.firstName;
          this.ck.roleId = succ.user.role.userRoleId;
          this.cookie.putObject('user', this.ck);
          localStorage.setItem('token', this.token);
          this.router.navigateByUrl('home');
        },
        (err) => {
          alert('failed to log in');
        }
      );

  }
}
