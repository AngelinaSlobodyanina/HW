import { AuthorService } from '../author.service';
import { Author } from '../author';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.css']
})
export class CreateAuthorComponent implements OnInit {

  author: Author = new Author();
  submitted = false;

  constructor(private authorService: AuthorService,
              private router: Router) { }

  ngOnInit() {
  }

  newAuthor(): void {
    this.submitted = false;
    this.author = new Author();
  }

  save() {
    this.authorService.createAuthor(this.author)
      .subscribe(data => console.log(data), error => console.log(error));
    this.author = new Author();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/authors']);
  }
}
