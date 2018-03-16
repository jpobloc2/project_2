import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  token;

  constructor() { }

  ngOnInit() {

    this.token = localStorage.getItem('token');
    // console.log(this.token);
    console.log(localStorage.getItem('token'));

  }

}
