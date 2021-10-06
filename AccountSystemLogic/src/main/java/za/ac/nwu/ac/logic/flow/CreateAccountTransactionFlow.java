package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.time.LocalDate;

public interface CreateAccountTransactionFlow {

    AccountTransactionDto create(String mnemonic, Long memberID, Long amount, LocalDate transactionDate);
}
