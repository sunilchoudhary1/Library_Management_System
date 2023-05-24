package project.major.librarymanagenent.service;

import org.springframework.web.bind.annotation.RequestBody;
import project.major.librarymanagenent.entity.Author;
import project.major.librarymanagenent.entity.Book;

import java.util.List;

public interface BookService {
    public String addBook(Book book) throws Exception;
    public List<Book> findall();
    public List<Book> findByAuthorid(int id);
    public int findByAuthor(Author author);
}
