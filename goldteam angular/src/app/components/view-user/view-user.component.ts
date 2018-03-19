import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { UserServiceService } from '../../services/user-service.service';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {

  private userId;
  private user;

  constructor(private client: HttpClient, private route: ActivatedRoute, private userService: UserServiceService) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.userId = params['user'];
    });
    this.client.get(`http://localhost:8080/users/${this.userId}`)
    .subscribe(
      succ => {
        this.user = succ;
        return this.user;

      }, err => {
        alert('failed to retrieve the user');
      }

    );
  }

  update(user: any) {
     this.userService.updateSub(this.user);
  }

}
