package project.major.librarymanagenent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.major.librarymanagenent.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
