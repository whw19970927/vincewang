package com.vincewang.dao;

import com.vincewang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Books books);


    int deleteBookById(@Param("bookId") int id);


    int updateBook(Books books);


    Books queryBookById(@Param("bookId")int id);


    List<Books> queryAllBook();


    Books queryBookByName(String bookName);
}
