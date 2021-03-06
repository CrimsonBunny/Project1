package za.ac.nwu.ac.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountBalanceTranslatorImpl.class);

    private final AccountBalanceRepository accountBalanceRepository;
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountBalanceTranslatorImpl(AccountBalanceRepository accountBalanceRepository, AccountTypeRepository accountTypeRepository) {
        this.accountBalanceRepository = accountBalanceRepository;
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public AccountBalanceDto create(AccountBalanceDto accountBalanceDto) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(accountBalanceDto.getMnemonic());
            AccountBalance accountBalance = accountBalanceRepository.save(accountBalanceDto.getAccountBalance(accountType));
            return new AccountBalanceDto(accountBalance);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountBalanceDto getAccountBalanceByMnemonic(Long memberID, String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            AccountBalanceDto accountBalanceDto = accountBalanceRepository.getAccountBalanceDtoByMemberID(memberID, accountType);
            LOGGER.info("The input was {} and the output was {}", memberID, accountBalanceDto);
            return accountBalanceDto;
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
