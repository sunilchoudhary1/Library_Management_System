package project.major.librarymanagenent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.major.librarymanagenent.entity.Author;
import project.major.librarymanagenent.entity.Book;
import project.major.librarymanagenent.repository.AuthorRepository;
import project.major.librarymanagenent.repository.BookRepository;
import project.major.librarymanagenent.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {

        Author author;
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present");
        }

        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book added";

    }

    @Override
    public List<Book> findall() {
        List<Book> list = bookRepository.findAll();
        return list;
    }

    @Override
    public List<Book> findByAuthorid(int id) {
        List<Book> list = bookRepository.findAll();
        List<Book> result = new ArrayList<>();
        for (Book b : list) {
            if (b.getAuthor().getId() == id) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public int findByAuthor(Author author) {
        List<Book> list = bookRepository.findAll();
        int ans = 0;
        for(Book b : list)
        {
            if(b.getAuthor()==author)
            {
                ans++;
            }
        }
        return ans;
    }
}
