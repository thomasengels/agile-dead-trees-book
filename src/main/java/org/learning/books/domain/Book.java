package org.learning.books.domain;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Book {
    private Long id;
    private String title;
    private LocalDate publishedDate;
    private Author author;

}
