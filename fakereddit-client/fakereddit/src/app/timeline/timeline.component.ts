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
      this.posts = posts.sort((p1,p2) => {
        return (p1.datePublish.getTime > p2.datePublish.getMilliseconds) ? 1 : -1;
      });
    });
  }

  upvote(post) {
    this.service.upvote(post.id).subscribe(result => {
      post.upvotes = result;
    },
    (error) => console.log(error));
  }
}
