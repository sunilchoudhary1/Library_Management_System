package project.major.librarymanagenent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.major.librarymanagenent.DTO.RequestDto.UpdateAuthorRequestDto;
import project.major.librarymanagenent.DTO.ResponseDto.AuthorResponseDto;
import project.major.librarymanagenent.entity.Author;
import project.major.librarymanagenent.repository.AuthorRepository;
import project.major.librarymanagenent.service.AuthorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author added";
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) {
        Author author = authorRepository.findByEmail(email);
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        return authorResponseDto;
    }

    @Override
    public AuthorResponseDto deleteAuthorById(int id) {
        Author author = authorRepository.findById(id).get();
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorRepository.deleteById(id);
        return authorResponseDto;
    }

    @Override
    public AuthorResponseDto updateAuthor(int id, UpdateAuthorRequestDto updateAuthorRequestDto) {
        Author author = authorRepository.findById(id).get();
        author.setName(updateAuthorRequestDto.getName());
        author.setAge(updateAuthorRequestDto.getAge());
        author.setEmail(updateAuthorRequestDto.getEmail());
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(updateAuthorRequestDto.getName());
        authorResponseDto.setAge(updateAuthorRequestDto.getAge());
        authorRepository.save(author);

        return authorResponseDto;
    }

    @Override
    public Author getById(int id) {
        Author author = authorRepository.findById(id).get();
        return author;
    }
    @Override
    public List<Author> listOfAuthor() {
        List<Author> list = authorRepository.findAll();
        return list;
    }

    @Override
    public List<Author> getByAge(int age) {

        List<Author> list = authorRepository.findAll();
        List<Author> result = new ArrayList<>();
        for(Author a : list)
        {
            if(a.getAge()==age)
            {
                result.add(a);
            }
        }
        return result;
    }
}
