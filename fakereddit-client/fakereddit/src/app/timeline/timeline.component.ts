import { Post } from './../models/post.model';
import { PostService } from './../services/post.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent implements OnInit {

  posts: any[];

  constructor(private service: PostService) { }

  ngOnInit(): void {
    this.service.getPosts().subscribe((posts: Post[]) => {
      this.posts = posts;
    });
  }
}
