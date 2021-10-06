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
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountBalanceFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountBalanceFlow;

@RestController
@RequestMapping("account-balance")
public class AccountBalanceController {

    private final CreateAccountBalanceFlow createAccountBalanceFlow;
    private final FetchAccountBalanceFlow fetchAccountBalanceFlow;

    @Autowired
    public AccountBalanceController(CreateAccountBalanceFlow createAccountBalanceFlow, FetchAccountBalanceFlow fetchAccountBalanceFlow) {
        this.createAccountBalanceFlow = createAccountBalanceFlow;
        this.fetchAccountBalanceFlow = fetchAccountBalanceFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates a new AccountType in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountBalance was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountBalanceDto>> create(
//            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
//                    example = "MILES",
//                    name = "mnemonic",
//                    required = true)
//            @RequestParam("mnemonic") final String mnemonic,
//            @ApiParam(value = "The ID that uniquely identifies the Member.",
//                    example = "1",
//                    name = "memberID",
//                    required = true)
//            @RequestParam("memberID") final Long memberID,
            @ApiParam(value = "Request body to create a new AccountBalance.", required = true)
            @RequestBody AccountBalanceDto accountBalance) {
        AccountBalanceDto accountBalanceResponse = createAccountBalanceFlow.create(accountBalance);
        GeneralResponse<AccountBalanceDto> response = new GeneralResponse<>(true, accountBalanceResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{memberID}")
    @ApiOperation(value = "Fetches the specified account balance.", notes = "Fetches the AccountBalance corresponding to the given member id and mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountBalanceDto>> getBalance(
            @ApiParam(value = "The id that uniquely identifies the member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") final Long memberID,

            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @RequestParam("mnemonic") final String mnemonic
    ) {
        AccountBalanceDto accountBalance = fetchAccountBalanceFlow.getAccountBalanceByMnemonic(memberID, mnemonic);
        GeneralResponse<AccountBalanceDto> response = new GeneralResponse<>(true, accountBalance);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
