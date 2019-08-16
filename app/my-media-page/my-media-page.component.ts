import { Component, OnInit, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Media } from 'src/model/media';
import { MediaService } from '../media.service';
import { DataService } from '../data.service';

@Component({
  selector: 'app-my-media-page',
  templateUrl: './my-media-page.component.html',
  styleUrls: ['./my-media-page.component.css']
})
export class MyMediaPageComponent implements OnInit {

  medias: Media[];
  userId: number;


  constructor(private router: Router, private mediaService: MediaService, private data: DataService) { }

  ngOnInit() {
    let userId = localStorage.getItem("userId");
    if (!userId) {
      alert("Logged out of your account, Please Login again")
      this.router.navigate(['sign-in']);
      return;
    }
    this.userId = parseInt(userId);
    this.mediaService.getMedias(this.userId).subscribe(response => this.handleResponse(response));
  }
  handleResponse(response){
    this.medias = response;
  }

}
