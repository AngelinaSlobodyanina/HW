import { AuthorDetailsComponent } from './author-details/author-details.component';
import { CreateAuthorComponent } from './create-author/create-author.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthorListComponent } from './author-list/author-list.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';

const routes: Routes = [
  { path: '', redirectTo: 'author', pathMatch: 'full' },
  { path: 'authors', component: AuthorListComponent },
  { path: 'add', component: CreateAuthorComponent },
  { path: 'update/:id', component: UpdateAuthorComponent },
  { path: 'details/:id', component: AuthorDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
