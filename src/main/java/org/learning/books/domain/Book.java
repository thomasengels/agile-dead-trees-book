package org.learning.books.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class Book {
    private Long id;
    private String title;
    private LocalDate publishedDate;
    private Author author;
}
