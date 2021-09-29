package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

public interface AccountTransactionTranslator {

    AccountTransactionDto create(AccountTransactionDto accountTransactionDto);

    AccountTransactionDto getBalanceByMnemonic(Long memberID, AccountTypeDto accountType);
}
