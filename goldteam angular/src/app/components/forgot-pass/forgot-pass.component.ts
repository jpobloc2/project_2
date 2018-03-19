import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserServiceService } from '../../services/user-service.service';

@Component({
  selector: 'app-forgot-pass',
  templateUrl: './forgot-pass.component.html',
  styleUrls: ['./forgot-pass.component.css']
})
export class ForgotPassComponent implements OnInit {

  constructor(private client: HttpClient, private router: Router, private userService: UserServiceService) { }

  username: string;
  ngOnInit() {
  }

  forgot() {
    this.userService.resetPassword(this.username);
  }

}
