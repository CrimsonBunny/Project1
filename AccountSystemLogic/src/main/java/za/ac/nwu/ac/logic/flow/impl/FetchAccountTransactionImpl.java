package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class FetchAccountTransactionImpl implements FetchAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final AccountTypeTranslator accountTypeTranslator;

    public FetchAccountTransactionImpl(AccountTransactionTranslator accountTransactionTranslator, AccountTypeTranslator accountTypeTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTransactionDto getBalanceByMnemonic(Long memberID, String mnemonic) {
        AccountTypeDto accountType = accountTypeTranslator.getAccountTypeDtoByMnemonic(mnemonic);
        return accountTransactionTranslator.getBalanceByMnemonic(memberID, accountType);
    }
}
