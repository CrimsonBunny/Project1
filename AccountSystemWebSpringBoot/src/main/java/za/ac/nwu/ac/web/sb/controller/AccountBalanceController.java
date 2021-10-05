package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountBalanceFlow;

@RestController
@RequestMapping("account-balance")
public class AccountBalanceController {

    private final CreateAccountBalanceFlow createAccountBalanceFlow;

    @Autowired
    public AccountBalanceController(CreateAccountBalanceFlow createAccountBalanceFlow) {
        this.createAccountBalanceFlow = createAccountBalanceFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates a new AccountType in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountBalanceDto>> create(
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
            @ApiParam(value = "Request body to create a new AccountBalance.", required = true)
            @RequestBody AccountBalanceDto accountBalance) {
        AccountBalanceDto accountBalanceResponse = createAccountBalanceFlow.create(accountBalance, memberID, mnemonic);
        GeneralResponse<AccountBalanceDto> response = new GeneralResponse<>(true, accountBalanceResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
