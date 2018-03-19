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
failPassAlert = false;

user;

  constructor(private userService: UserServiceService) { }

  ngOnInit() {
    this.user = this.userService.getStoredUser();
  }

  changePass() {
    if (this.password1 !== this.password2) {
      this.failPassAlert = true;
    } else {
      this.user.password = this.password1;
      this.userService.changePassword(this.password1);

    }
  }

}
