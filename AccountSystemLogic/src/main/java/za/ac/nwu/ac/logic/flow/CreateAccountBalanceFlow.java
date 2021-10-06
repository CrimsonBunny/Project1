package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountBalanceDto;

public interface CreateAccountBalanceFlow {
    AccountBalanceDto create(AccountBalanceDto accountBalance);
}
