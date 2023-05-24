package project.major.librarymanagenent.DTO.ResponseDto;

import lombok.*;
import project.major.librarymanagenent.enums.TransactionStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {

    private String transactionNumber;

    private TransactionStatus transactionStatus;

    private String bookName;
}
