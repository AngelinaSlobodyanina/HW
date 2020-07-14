import { AuthorDetailsComponent } from '../author-details/author-details.component';
import { Observable } from "rxjs";
import { AuthorService } from "./../author.service";
import { Author } from "./../author";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-author-list",
  templateUrl: "./author-list.component.html",
  styleUrls: ["./author-list.component.css"]
})
export class AuthorListComponent implements OnInit {
  authors: Observable<Author[]>;

  constructor(private authorService: AuthorService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.authors = this.authorService.getAuthorList();
  }

  deleteAuthor(id: number) {
    this.authorService.deleteAuthor(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  authorDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateAuthor(id: number){
    this.router.navigate(['update', id]);
  }
}
