package org.learning.books.repository;

import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    static Specification<BookEntity> hasTitle(String title){
        return (root, query, cb) -> cb.like(root.get("title"), "%" + title + "%");
    }
}
