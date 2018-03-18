import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../../services/user-service.service';

@Component({
  selector: 'app-pass-reset',
  templateUrl: './pass-reset.component.html',
  styleUrls: ['./pass-reset.component.css']
})
export class PassResetComponent implements OnInit {

password1;
password2;

user;

  constructor(private userService: UserServiceService) { }

  ngOnInit() {
    this.user = this.userService.getStoredUser();
    console.log(this.user);
  }

  changePass() {
    if (this.password1 !== this.password2) {
      alert('Passwords do not match!');
    } else {
      this.user.password = this.password1;
      console.log(this.user);
      this.userService.changePassword(this.user);

    }
  }

}
