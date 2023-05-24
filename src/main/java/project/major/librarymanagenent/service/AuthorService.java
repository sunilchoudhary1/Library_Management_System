package project.major.librarymanagenent.service;

import project.major.librarymanagenent.DTO.RequestDto.UpdateAuthorRequestDto;
import project.major.librarymanagenent.DTO.ResponseDto.AuthorResponseDto;
import project.major.librarymanagenent.entity.Author;

import java.util.List;

public interface AuthorService {
    public String addAuthor(Author author);
    public AuthorResponseDto getAuthorByEmail(String email);
    public AuthorResponseDto deleteAuthorById(int id);
    public AuthorResponseDto updateAuthor(int id, UpdateAuthorRequestDto updateAuthorRequestDto);
    public Author getById(int id);
    public List<Author> listOfAuthor();
    public List<Author> getByAge(int age);
}