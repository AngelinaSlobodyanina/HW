import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAuthorComponent } from './create-author/create-author.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateAuthorComponent } from './update-author/update-author.component';
import {AuthorDetailsComponent} from './author-details/author-details.component';
import {AuthorListComponent} from './author-list/author-list.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateAuthorComponent,
    AuthorDetailsComponent,
    AuthorListComponent,
    UpdateAuthorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
