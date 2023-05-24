package project.major.librarymanagenent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.major.librarymanagenent.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
