package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document
public class Author {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String bookId;

    public Author() {

    }

    public Author(String firstName, String lastName, String bookId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookId = bookId;
    }

   // @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

   // @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   // @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   // @Column(name = "book_address", nullable = false)
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

   // @Override
   /* public String toString() {
        return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", bookId=" + bookId
                + "]";
    }*/

}
