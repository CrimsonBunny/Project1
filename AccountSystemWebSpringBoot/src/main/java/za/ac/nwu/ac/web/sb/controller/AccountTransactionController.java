package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;

import java.time.LocalDate;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow) {
        this.createAccountTransactionFlow = createAccountTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates a new AccountType in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @RequestParam("mnemonic") final String mnemonic,
            @ApiParam(value = "The ID that uniquely identifies the Member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @RequestParam("memberID") final Long memberID,
            @ApiParam(value = "The amount added to the account balance",
                    example = "100",
                    name = "amount",
                    required = true)
            @RequestParam("amount") final Long amount,
            @ApiParam(value = "The optional new date with which to update the CreationDate in ISO date format (yyyy-MM-dd)\r\nIf empty/null it will not be updated.",
                    name = "transactionDate")
            @RequestParam(value = "transactionDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate transactionDate) {
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.create(mnemonic, memberID, amount, transactionDate);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
