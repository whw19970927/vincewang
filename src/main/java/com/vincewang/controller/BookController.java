package com.vincewang.controller;

import com.vincewang.pojo.Books;
import com.vincewang.service.BookService;
import com.vincewang.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService=new BookServiceImpl();

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list=bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addBook(Books books){
               bookService.addBook(books);
        return "redirect://book//allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);

        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId")int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(Model model,String queryBookName){
        Books book=bookService.queryBookByName(queryBookName);
        List<Books> list=new ArrayList<Books>();
        list.add(book);
        model.addAttribute("list",list);
        return "allBook";
    }
}
