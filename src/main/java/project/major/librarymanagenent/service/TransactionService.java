package project.major.librarymanagenent.service;

import project.major.librarymanagenent.DTO.RequestDto.IssueBookRequestDto;
import project.major.librarymanagenent.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
