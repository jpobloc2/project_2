import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class UserServiceService {



  constructor(private client: HttpClient) { }
  header;
  obv: Subject<any> = new Subject;

  getMyInfo() {
    this.header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
    this.client.get('http://localhost:8080/users/', {headers: this.header})
    .subscribe(
      succ => {
        console.log('User service returned ' + succ);
        console.log(succ);
        this.obv.next(succ);
      }, err => {
        alert('failed to retrieve this user');
      }

    );
  }

}
