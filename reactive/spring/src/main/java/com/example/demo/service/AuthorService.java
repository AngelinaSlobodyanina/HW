package com.example.demo.service;

import com.example.demo.model.Author;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorService {
    Mono<Author> getAuthor(Long id);

    Mono<Author> createAuthor(Mono<Author> authorMono);

    Mono<Author> updateAuthor(Long id, Mono<Author> authorMono);

    Mono<Boolean> deleteAuthor(Long id);

    Flux<Author> listAllAuthors();
}

