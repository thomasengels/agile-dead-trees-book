package org.learning.books.repository;

import org.learning.books.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Books  {
    List<Book> findAll();
}
