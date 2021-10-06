package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.logic.flow.FetchAccountBalanceFlow;
import za.ac.nwu.ac.translator.AccountBalanceTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class FetchAccountBalanceImpl implements FetchAccountBalanceFlow {

    private final AccountBalanceTranslator accountBalanceTranslator;

    public FetchAccountBalanceImpl(AccountBalanceTranslator accountBalanceTranslator) {
        this.accountBalanceTranslator = accountBalanceTranslator;
    }

    @Override
    public AccountBalanceDto getAccountBalanceByMnemonic(Long memberID, String mnemonic) {
        return accountBalanceTranslator.getAccountBalanceByMnemonic(memberID, mnemonic);
    }
}
