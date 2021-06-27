import { TimelineComponent } from './timeline/timeline.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewPublishComponent } from './new-publish/new-publish.component';

const routes: Routes = [
  {path: '', redirectTo: 'timeline', pathMatch: 'full'},
  {path: 'new-publish', component: NewPublishComponent},
  {path: 'timeline', component: TimelineComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
