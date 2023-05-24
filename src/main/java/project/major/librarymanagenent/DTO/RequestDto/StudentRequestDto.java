package project.major.librarymanagenent.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.major.librarymanagenent.enums.Department;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDto {

    private String name;

    private int age;

    private Department department;

    private String mobNo;
}
