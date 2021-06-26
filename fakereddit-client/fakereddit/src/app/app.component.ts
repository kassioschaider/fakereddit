import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'fakereddit';
  posts: any[] = [];

  publish($event) {
    const post = {...$event, date: new Date(), votes: 0}
    this.posts.push(post);
  }
}
