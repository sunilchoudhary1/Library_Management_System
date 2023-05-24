package project.major.librarymanagenent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.major.librarymanagenent.DTO.RequestDto.UpdateAuthorRequestDto;
import project.major.librarymanagenent.DTO.ResponseDto.AuthorResponseDto;
import project.major.librarymanagenent.entity.Author;
import project.major.librarymanagenent.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }
    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email") String email)
    {
        return authorService.getAuthorByEmail(email);
    }
    @DeleteMapping("/delete/{id}")
    public AuthorResponseDto deleteAuthorById(@PathVariable(value = "id") int id)
    {
        return authorService.deleteAuthorById(id);
    }
    @PutMapping("/update-author/{id}")
    public AuthorResponseDto updateAuthor(@PathVariable(value = "id") int id, @RequestBody UpdateAuthorRequestDto updateAuthorRequestDto)
    {
        return authorService.updateAuthor(id, updateAuthorRequestDto);
    }
    @GetMapping("get-by-id/{id}")
    public Author getById(@PathVariable(value="id") int id)
    {
        return authorService.getById(id);
    }
    @GetMapping("/list-of-authors")
    public List<Author> listOfAuthor()
    {
        return authorService.listOfAuthor();
    }
    @GetMapping("/get-by-age/{age}")
    public List<Author> getByAge(@PathVariable(value = "age") int age)
    {
        return authorService.getByAge(age);
    }

}
