package project.major.librarymanagenent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.major.librarymanagenent.entity.Transaction;
@Repository
public interface TransectionRepository extends JpaRepository<Transaction, Integer> {
}
