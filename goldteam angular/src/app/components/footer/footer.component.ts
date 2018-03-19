import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
  complaintEmail = {
    complainant: '',
    complainantAddr: '',
    complainantMsg: ''
  };
  sucAlert = false;
  failAlert = false;

  constructor(private client: HttpClient) { }

  ngOnInit() {
  }

  submitIssue() {
    if (this.complaintEmail.complainant === '') {
      alert('Please enter your name.');
    } else if (this.complaintEmail.complainantAddr === '') {
      alert('Please enter your email.');
    } else if (this.complaintEmail.complainantMsg === '') {
      alert('Please enter information about the issue you are having.');
    } else {
      this.client.post('http://localhost:8080/users/complaint', this.complaintEmail, {headers: this.header})
      .subscribe(
        (succ) => {
          this.sucAlert = true;
        },
        (err) => {
          this.failAlert = true;
        }
      );
    }
  }
}
