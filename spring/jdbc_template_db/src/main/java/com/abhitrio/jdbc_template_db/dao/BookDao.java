package com.abhitrio.jdbc_template_db.dao;

import com.abhitrio.jdbc_template_db.domain.Book;

import java.util.Optional;

public interface BookDao {

    void create(Book book);

    Optional<Book> find(String isbn);
}
