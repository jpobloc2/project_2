import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Subject } from 'rxjs/Subject';
import { Router } from '@angular/router';

@Injectable()
export class UserServiceService {



  constructor(private client: HttpClient, private router: Router) { }
  header;
  obv: Subject<any> = new Subject;

  user;

  getMyInfo() {
    this.header = new HttpHeaders({ xtoken: `${localStorage.getItem('token')}` });
    this.client.get('http://localhost:8080/users/', { headers: this.header })
      .subscribe(
        succ => {
          console.log('User service returned ' + succ);
          console.log(succ);
          this.obv.next(succ);
          this.user = succ;
        }, err => {
          alert('failed to retrieve this user');
        }

      );
  }

  updateUser(user: any) {
    this.header = new HttpHeaders({ xtoken: `${localStorage.getItem('token')}` });
    console.log('User updated test to see service runs');
    this.client.post('http://localhost:8080/users/change', user, { headers: this.header })
      .subscribe(
        succ => {
          alert('user successfully updated');
          console.log(succ);
          this.router.navigateByUrl('/manager');
        }, err => {
          alert('failed to update this user');
        }
      );

  }

  resetPassword(username: string) {
    console.log('user service resetting ' + username + `'s password`);
    this.client.get(`http://localhost:8080/users/forgotPass/${username}`)
      .subscribe(
        succ => {
          alert('Password reset: Check the email associated with this account.');
          this.router.navigateByUrl('/login');
        }, err => {
          alert('No account found with this username, double check your input and try again!');
        }

      );
  }

  changePassword(user: any) {
    console.log('user service attempting to change password');
    this.header = new HttpHeaders({ xtoken: `${localStorage.getItem('token')}` });
    this.client.put('http://localhost:8080/users/changePass', user, { headers: this.header })
    .subscribe(
      succ => {
        alert('Password successfully changed!');
        this.router.navigateByUrl('/account-info');
      }, err => {
        alert('Failed to change password');
      }
    );

  }

  getStoredUser() {
    return this.user;
  }

}
