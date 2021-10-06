package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.time.LocalDate;

public interface AccountTransactionTranslator {

    AccountTransactionDto create(String mnemonic, Long memberID, Long amount, LocalDate transactionDate);

    AccountTransactionDto getBalanceByMnemonic(Long memberID, String mnemonic);
}
