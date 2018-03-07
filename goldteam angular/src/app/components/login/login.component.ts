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

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.client.post('http://localhost:8080/Reimbursement-System/login', this.credentials,
      { withCredentials: true })
      .subscribe(
        (succ: any) => {
          alert(this.credentials.username +  ` has logged in`);
          this.cookie.putObject('user', succ);
          this.router.navigateByUrl('home');
          console.log(this.cookie);
        },
        (err) => {
          alert('failed to log in');
        }
      );

  }
}
