import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { UserServiceService } from '../../services/user-service.service';

@Component({
  selector: 'app-view-me',
  templateUrl: './view-me.component.html',
  styleUrls: ['./view-me.component.css']
})
export class ViewMeComponent implements OnInit {

  private user;

  constructor(private userService: UserServiceService, private cookie: CookieService) { }

  ngOnInit() {
    this.userService.getMyInfo();
    this.userService.obv.subscribe((data => {
      this.user = data;
    }));
  }

  update() {
    this.userService.updateUser(this.user);
  }

}
