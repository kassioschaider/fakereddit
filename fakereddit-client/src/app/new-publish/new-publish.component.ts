import { Post } from './../models/post.model';
import { PostService } from './../services/post.service';
import { Component } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-publish',
  templateUrl: './new-publish.component.html',
  styleUrls: ['./new-publish.component.scss']
})
export class NewPublishComponent {
  content: string;
  errors: string = '';

  constructor(private service: PostService, private router: Router) { }

  publish() {
    this.errors = '';
    const post: Post = { content: this.content };

    this.service.addPost(post).subscribe(result => {
      console.log(result);
      this.cleanField();
      this.router.navigateByUrl('timeline');
    },
    (error) => {
      error.error.forEach(e => {
        this.errors = this.errors + e.field + ' - ' + e.error;
      });
    });
  }

  cleanField() {
    this.content = '';
  }
}
