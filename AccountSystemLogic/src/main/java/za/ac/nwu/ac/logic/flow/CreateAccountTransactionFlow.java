package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {

    AccountTransactionDto add(AccountTransactionDto accountTransaction, String mnemonic);

    AccountTransactionDto subtract(AccountTransactionDto accountTransaction, String mnemonic);
}
