import { BrowserModule } from '@angular/platform-browser';
import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';

import { AppComponent } from './app.component';
import { NewPublishComponent } from './new-publish/new-publish.component';
import { TimelineComponent } from './timeline/timeline.component';

registerLocaleData(localePt, 'pt');

@NgModule({
  declarations: [
    AppComponent,
    NewPublishComponent,
    TimelineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt' },
    {
      provide: DEFAULT_CURRENCY_CODE,
      useValue: 'BRL',
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
