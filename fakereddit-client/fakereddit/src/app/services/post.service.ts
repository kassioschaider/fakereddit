import { Post } from './../models/post.model';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private resouceUrl = environment.apiUrl + '/posts';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private httpClient: HttpClient) { }

  getPosts(): Observable<Post[]> {
    return this.httpClient.get<Post[]>(this.resouceUrl);
  }

  addPost(post: Post): Observable<Post> {
    return this.httpClient.post<Post>(this.resouceUrl, JSON.stringify(post), this.httpOptions);
  }

  upvote(idPost): Observable<Post> {
    return this.httpClient.put<Post>(
      this.resouceUrl + '/' + JSON.stringify(idPost) + '/upvote', this.httpOptions
    );
  }
}
