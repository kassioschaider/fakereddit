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

  constructor(private service: PostService, private router: Router) { }

  publish() {
    const post: Post = { content: this.content };

    this.service.addPost(post).subscribe(resultado => {
      console.log(resultado);
      this.cleanField();
      this.router.navigateByUrl('timeline');
    },
    (error) => console.log(error));
  }

  cleanField() {
    this.content = '';
  }
}
