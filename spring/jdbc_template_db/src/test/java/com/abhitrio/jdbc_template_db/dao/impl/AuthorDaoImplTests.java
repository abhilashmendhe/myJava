package com.abhitrio.jdbc_template_db.dao.impl;

import com.abhitrio.jdbc_template_db.dao.impl.AuthorDaoImpl;
import com.abhitrio.jdbc_template_db.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql() {
        Author author = Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();

        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Abigail Rose"), eq(80)
        );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSQL(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                "SELECT id, name, age FROM authors WHERE id=? LIMIT 1",
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }


}