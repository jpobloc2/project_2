import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-view-me',
  templateUrl: './view-me.component.html',
  styleUrls: ['./view-me.component.css']
})
export class ViewMeComponent implements OnInit {

  ck;

  constructor(private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
  }

}
