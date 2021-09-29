package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class CreateAccountTransactionImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    public CreateAccountTransactionImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto add(AccountTransactionDto accountTransaction) {
        if (null == accountTransaction.getTransactionDate()) {
            accountTransaction.setTransactionDate(LocalDate.now());
        }

        return accountTransactionTranslator.create(accountTransaction);
    }

    @Override
    public AccountTransactionDto subtract(AccountTransactionDto accountTransaction) {
        if (null == accountTransaction.getTransactionDate()) {
            accountTransaction.setTransactionDate(LocalDate.now());
        }

        return accountTransactionTranslator.create(accountTransaction);
    }
}
