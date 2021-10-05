package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountBalance;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountBalanceRepository;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountBalanceTranslator;

@Component
public class AccountBalanceTranslatorImpl implements AccountBalanceTranslator {

    private final AccountBalanceRepository accountBalanceRepository;
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountBalanceTranslatorImpl(AccountBalanceRepository accountBalanceRepository, AccountTypeRepository accountTypeRepository) {
        this.accountBalanceRepository = accountBalanceRepository;
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public AccountBalanceDto create(AccountBalanceDto accountBalanceDto, Long memberID, String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            AccountBalance accountBalance = accountBalanceRepository.save(accountBalanceDto.getAccountBalance(accountType));
            return new AccountBalanceDto(accountBalance);
        } catch (Exception e) {
            throw new RuntimeException("unable to save to the DB", e);
        }
    }
}
