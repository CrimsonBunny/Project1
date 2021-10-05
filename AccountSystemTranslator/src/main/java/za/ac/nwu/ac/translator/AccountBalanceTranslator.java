package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountBalanceDto;

public interface AccountBalanceTranslator {

    AccountBalanceDto create(AccountBalanceDto accountBalanceDto, Long memberID, String mnemonic);
}
