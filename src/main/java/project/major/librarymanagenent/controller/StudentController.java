package project.major.librarymanagenent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.major.librarymanagenent.DTO.RequestDto.StudentRequestDto;
import project.major.librarymanagenent.DTO.RequestDto.UpdateStudentMobRequestDto;
import project.major.librarymanagenent.DTO.ResponseDto.StudentResponseDto;
import project.major.librarymanagenent.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import project.major.librarymanagenent.entity.Student;
import project.major.librarymanagenent.exceptions.StudentNotFoundException;
import project.major.librarymanagenent.repository.StudentRepository;
import project.major.librarymanagenent.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto) {

        return studentService.addStudent(studentRequestDto);
    }

    @PutMapping("/update_mobile")
    public UpdateStudentMobNoResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        return studentService.updateMobNo(updateStudentMobRequestDto);
    }

    @GetMapping("/get_student/{id}")
    public StudentResponseDto getStudent(@RequestParam(value = "id") int id) {
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteByid(@PathVariable(value = "id") int id)
    {
        return studentService.deleteByid(id);
    }
    @PutMapping("update-by-id/{id}")
    public StudentResponseDto updateByid(@PathVariable(value = "id") int id, @RequestParam String name, @RequestParam int age, @RequestParam String mobNo)
    {
        return studentService.updateByid(id, name, age, mobNo);
    }
    public List<Student> findAllStudent()
    {
        return studentService.findAllStudent();
    }
}
