package org.learning.books.repository;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.learning.books.domain.Book;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@NoArgsConstructor
public class BookEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publishingDate")
    private LocalDate publishingDate;

    private BookEntity(Long id, String title, LocalDate publishingDate) {
        this.id = id;
        this.title = title;
        this.publishingDate = publishingDate;
    }

    public static BookEntity create(String title, LocalDate publishingDate){
        return new BookEntity(null, title, publishingDate);
    }



    public Book toDomain() {
        return Book.builder()
                .id(this.id)
                .title(this.title)
                .build();
    }
}
