package com.vincewang.service;

import com.vincewang.pojo.Books;

import java.util.List;

public interface BookService {
    int addBook(Books books);


    int deleteBookById(int id);


    int updateBook(Books books);


    Books queryBookById(int id);


    List<Books> queryAllBook();

    Books queryBookByName(String bookName);
}
