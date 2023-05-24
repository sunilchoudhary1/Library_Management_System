package project.major.librarymanagenent.service;

import org.springframework.web.bind.annotation.PathVariable;
import project.major.librarymanagenent.DTO.RequestDto.StudentRequestDto;
import project.major.librarymanagenent.DTO.RequestDto.UpdateStudentMobRequestDto;
import project.major.librarymanagenent.DTO.ResponseDto.StudentResponseDto;
import project.major.librarymanagenent.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import project.major.librarymanagenent.entity.Student;
import project.major.librarymanagenent.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);

    public StudentResponseDto getStudentById(int id);
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;
    public String deleteByid(int id);
    StudentResponseDto updateByid(int id, String name, int age, String mobNo);
    public List<Student> findAllStudent();


}
