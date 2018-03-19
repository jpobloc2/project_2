import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-make-user',
  templateUrl: './make-user.component.html',
  styleUrls: ['./make-user.component.css']
})
export class MakeUserComponent implements OnInit {

  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});

  newUser = {
    firstName: '',
    lastName: '',
    userEmail: ''
  };

  failNullAlert = false;
  failCreateAlert = false;
  failSubmissionAlert = false;

  constructor(private client: HttpClient) { }

  ngOnInit() {
  }

  makeUser() {
    if ((this.newUser.firstName === '' || this.newUser.lastName === '' || this.newUser.userEmail === '')) {
      this.failNullAlert = true;
    } else {
      this.client.post('http://localhost:8080/users/new', this.newUser, {headers: this.header})
    .subscribe(
      succ => {
        this.failCreateAlert = true;
      },
      err => {
        this.failSubmissionAlert = true;
      }
    );
    }
  }

}
