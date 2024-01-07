package com.abhitrio.jdbc_template_db.dao;

import com.abhitrio.jdbc_template_db.domain.Author;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AuthorDao {

    void create(Author author);

    Optional<Author> findOne(long l);
}
