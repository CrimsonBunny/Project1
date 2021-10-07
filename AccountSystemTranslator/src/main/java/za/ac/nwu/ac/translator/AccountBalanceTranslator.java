package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

public interface AccountBalanceTranslator {

    AccountBalanceDto create(AccountBalanceDto accountBalanceDto);

    AccountBalanceDto getAccountBalanceByMnemonic(Long memberID, String mnemonic);
}
