import { Component, Output } from "@angular/core";
import { EventEmitter } from "@angular/core";

@Component({
  selector: 'app-new-publish',
  templateUrl: './new-publish.component.html',
  styleUrls: ['./new-publish.component.scss']
})
export class NewPublishComponent {

  @Output() toPublish = new EventEmitter<any>();

  content: string;

  publish() {
    this.toPublish.emit({
      content: this.content
    });
    this.cleanField();
  }

  cleanField() {
    this.content = '';
  }
}
