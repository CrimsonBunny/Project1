package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

public interface AccountBalanceTranslator {

    AccountBalanceDto create(AccountBalanceDto accountBalanceDto, String mnemonic);

    AccountBalanceDto getAccountBalanceByMnemonic(Long memberID, String mnemonic);
}
