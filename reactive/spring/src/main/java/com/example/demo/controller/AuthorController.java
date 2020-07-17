package com.example.demo.controller;


import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Author;
//import com.example.demo.repository.AuthorRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/api/v1")
@RestController
@RequestMapping( "/api/v1")
@CrossOrigin
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService =authorService;
    }

    @GetMapping("/authors")
    public Flux<Author> getAllAuthors() {

            return authorService.listAllAuthors();
        }


        @GetMapping("/authors/{id}")
    public Mono<Author> getAuthorById(@PathVariable(value = "id") Long authorId)
            {
        return authorService.getAuthor(authorId);
    }

    @PostMapping("/authors/{id}")
    public Mono<Author> createAuthor(@PathVariable(value = "id") Long authorId,
                               @RequestBody Mono<Author> author) {
        return authorService.updateAuthor(authorId,author);
    }

    @PutMapping("/authors")
    public Mono<Author> createAuthor(@RequestBody Mono<Author> author)
    {return authorService.createAuthor(author);
    }

    @DeleteMapping("/authors/{id}")
    public Mono< Boolean> deleteAuthor(@PathVariable(value = "id") Long authorId)
    {       return authorService.deleteAuthor(authorId);
    }
}
