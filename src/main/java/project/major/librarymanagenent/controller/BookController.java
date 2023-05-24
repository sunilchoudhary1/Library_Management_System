package project.major.librarymanagenent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.major.librarymanagenent.entity.Author;
import project.major.librarymanagenent.entity.Book;
import project.major.librarymanagenent.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {

        return bookService.addBook(book);
    }
    @GetMapping("/find-all")
    public List<Book> findall()
    {
        return bookService.findall();
    }
    @GetMapping("/find-by-authorid/{id}")
    public List<Book> findByAuthorid(@PathVariable(value = "id") int id)
    {
        return bookService.findByAuthorid(id);
    }
    @GetMapping("/find-by-author")
    public int findByAuthor(@RequestBody Author author)
    {
        return bookService.findByAuthor(author);
    }
}
