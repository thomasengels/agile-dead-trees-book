package org.learning.books.repository;

import org.learning.books.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class BookRepository extends AbstractRepository<BookEntity, Long> implements Books {
    public List<Book> findAll(){
        return StreamSupport.stream(super.findAll().spliterator(), false)
                .map(BookEntity::toDomain)
                .toList();
    }
}
