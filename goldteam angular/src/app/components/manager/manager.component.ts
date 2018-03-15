import { Component, OnInit } from '@angular/core';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});

  userList: any = [];

  constructor(private cookie: CookieService, private client: HttpClient, private router: Router) { }

  ngOnInit() {
    this.client.get('http://localhost:8080/users/all', {headers: this.header})
      .subscribe(
        succ => {
          this.userList = succ;
          console.log(succ);
          return this.userList;

        }, err => {
          alert('failed to retrieve all users');
        }

      );


  }

  view(User: any) {
    this.router.navigateByUrl('view-user', { queryParams: User, queryParamsHandling: 'preserve'});
  }

}
