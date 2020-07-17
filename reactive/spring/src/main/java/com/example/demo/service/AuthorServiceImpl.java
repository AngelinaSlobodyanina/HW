package com.example.demo.service;

import com.example.demo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    public AuthorServiceImpl(ReactiveMongoOperations reactiveMongoOperations) {
        this.reactiveMongoOperations = reactiveMongoOperations;
    }
    @Override
    public Mono<Author> getAuthor(Long id){
        return reactiveMongoOperations.findById(id, Author.class);
    }

   @Override
   public Mono<Author> createAuthor(Mono<Author> authorMono){
       return reactiveMongoOperations.save(authorMono);
   }

   @Override
   public Mono<Author> updateAuthor(Long id, Mono<Author> authorMono){
       return authorMono.flatMap(author -> reactiveMongoOperations.findAndModify(
               Query.query(Criteria.where("id").is(id)),
               Update.update("FirstName", author.getFirstName()) ,Author.class).
               flatMap(result -> {
                   result.setFirstName(author.getFirstName());
                   return Mono.just(result);
               })
       );
   }

   @Override
   public Mono<Boolean> deleteAuthor(Long id){
       return reactiveMongoOperations.remove(
               Query.query(Criteria.where("id").is(id)), Author.class
       ).flatMap(deleteResult -> Mono.just(deleteResult.wasAcknowledged()));
   }

   @Override
   public Flux<Author> listAllAuthors(){

        return reactiveMongoOperations.findAll(Author.class);
   }
}

