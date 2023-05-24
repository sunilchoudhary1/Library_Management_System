package project.major.librarymanagenent.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateAuthorRequestDto {
    private String name;
    private int age;
    private String email;
}
