package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

public interface FetchAccountTransactionFlow {
    AccountTransactionDto getBalanceByMnemonic(Long memberID, String mnemonic);
}
