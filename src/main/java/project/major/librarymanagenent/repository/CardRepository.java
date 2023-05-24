package project.major.librarymanagenent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.major.librarymanagenent.entity.Card;
@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
