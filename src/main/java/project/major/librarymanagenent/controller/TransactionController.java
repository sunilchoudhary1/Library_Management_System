package project.major.librarymanagenent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.major.librarymanagenent.DTO.RequestDto.IssueBookRequestDto;
import project.major.librarymanagenent.DTO.ResponseDto.IssueBookResponseDto;
import project.major.librarymanagenent.service.TransactionService;

@RestController
@RequestMapping("/transection")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {

        return transactionService.issueBook(issueBookRequestDto);
    }
}
