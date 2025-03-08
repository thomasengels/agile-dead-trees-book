package org.learning.books.repository;

import org.learning.books.BookController;
import org.learning.books.domain.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

/*
https://www.linkedin.com/pulse/applying-domain-driven-design-ddd-repository-pattern-real-world-cponf?utm_source=rss&utm_campaign=articles_sitemaps&utm_medium=google_news
 */

@Repository
public class BookRepositoryImpl implements Books{

    private final BookRepository repository;
    private final BookController book;

    protected BookRepositoryImpl(BookRepository repository, BookController book) {
        this.repository = repository;
        this.book = book;
    }

    @Override
    public List<Book> findAll() {
        return this.repository.findAll().stream()
                .map(BookEntity::toDomain)
                .toList();
    }

    @Override
    public Book save(Book book) {
        BookEntity saved = this.repository.save(BookEntity.create(book.getTitle(), book.getPublishedDate()));
        return saved.toDomain();
    }

    @Override
    public Book findById(Long id) {
        return this.repository.findById(id).map(BookEntity::toDomain).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
          this.repository.deleteById(id);
    }

    @Override
    public List<Book> findByTitle(String title) {
        Specification<BookEntity> hasTitle = BookSpecification.hasTitle(title);
        return this.repository.findAll(where(hasTitle)).stream()
                .map(BookEntity::toDomain)
                .toList();
    }
}
