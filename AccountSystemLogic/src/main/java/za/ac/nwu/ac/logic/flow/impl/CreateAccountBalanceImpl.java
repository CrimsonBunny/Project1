package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.logic.flow.CreateAccountBalanceFlow;
import za.ac.nwu.ac.translator.AccountBalanceTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateAccountBalanceImpl implements CreateAccountBalanceFlow {

    private final AccountBalanceTranslator accountBalanceTranslator;

    public CreateAccountBalanceImpl(AccountBalanceTranslator accountBalanceTranslator) {
        this.accountBalanceTranslator = accountBalanceTranslator;
    }

    @Override
    public AccountBalanceDto create(AccountBalanceDto accountBalance, Long memberID, String mnemonic) {
        return accountBalanceTranslator.create(accountBalance, memberID, mnemonic);
    }
}
