import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FollowService } from '../follow.service';
import { Follow } from 'src/model/follow';

@Component({
  selector: 'app-follow',
  templateUrl: './follow.component.html',
  styleUrls: ['./follow.component.css']
})
export class FollowComponent implements OnInit {

  followers: any;
  followings: any;

  constructor(private router: Router, private follow: FollowService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['sign-in']);
      return;
    }
    this.follow.getFollowers(1).subscribe(response => console.log(response));
    this.follow.getFollowings(3).subscribe(response => console.log(response));
  }

}
