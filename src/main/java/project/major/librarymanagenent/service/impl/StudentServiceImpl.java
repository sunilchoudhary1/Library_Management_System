package project.major.librarymanagenent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.major.librarymanagenent.DTO.RequestDto.StudentRequestDto;
import project.major.librarymanagenent.DTO.RequestDto.UpdateStudentMobRequestDto;
import project.major.librarymanagenent.DTO.ResponseDto.CardResponseDto;
import project.major.librarymanagenent.DTO.ResponseDto.StudentResponseDto;
import project.major.librarymanagenent.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import project.major.librarymanagenent.entity.Card;
import project.major.librarymanagenent.entity.Student;
import project.major.librarymanagenent.enums.CardStatus;
import project.major.librarymanagenent.exceptions.StudentNotFoundException;
import project.major.librarymanagenent.repository.StudentRepository;
import project.major.librarymanagenent.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student added";
    }

    @Override
    public StudentResponseDto getStudentById(int id) {

        Student student = studentRepository.findById(id).get();

        // prepare responsedto
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMobNo(student.getMobNo());

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
        cardResponseDto.setValidTill(student.getCard().getValidTill());
        cardResponseDto.setId(student.getCard().getId());

        studentResponseDto.setCardResponseDto(cardResponseDto);
        return studentResponseDto;
    }

    @Override
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        try{
            Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            // prepare response dto
            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setName(updatedStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updateStudentMobRequestDto.getMobNo());
            return updateStudentMobNoResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid student id");
        }
    }

    @Override
    public String deleteByid(int id) {
        studentRepository.deleteById(id);
        return "Student deleted "+id;
    }

    @Override
    public StudentResponseDto updateByid(int id, String name, int age, String mobNo) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        Student student = studentRepository.findById(id).get();
        student.setName(name);
        student.setAge(age);
        student.setMobNo(mobNo);
        studentRepository.save(student);
        studentResponseDto.setName(name);
        studentResponseDto.setAge(age);
        studentResponseDto.setMobNo(mobNo);
        return studentResponseDto;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> list = studentRepository.findAll();
        return list;
    }
}
