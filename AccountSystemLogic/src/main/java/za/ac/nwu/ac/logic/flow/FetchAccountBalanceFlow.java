package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountBalanceDto;

public interface FetchAccountBalanceFlow {
    AccountBalanceDto getAccountBalanceByMnemonic(Long memberID, String mnemonic);
}
