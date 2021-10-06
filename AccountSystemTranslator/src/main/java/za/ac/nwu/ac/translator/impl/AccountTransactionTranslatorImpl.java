package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountBalance;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountBalanceRepository;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.time.LocalDate;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final AccountBalanceRepository accountBalanceRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository, AccountTypeRepository accountTypeRepository, AccountBalanceRepository accountBalanceRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.accountBalanceRepository = accountBalanceRepository;
    }

    @Override
    public AccountTransactionDto create(String mnemonic, Long memberID, Long amount, LocalDate transactionDate) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);

            accountBalanceRepository.addAccountBalance(memberID, accountType, amount);
            AccountBalance accountBalance = accountBalanceRepository.getAccountBalanceByMemberID(memberID);

            AccountTransaction transaction = new AccountTransaction(accountType, accountBalance, amount, transactionDate);
            AccountTransactionDto accountTransactionDto = new AccountTransactionDto(transaction);

            AccountTransaction accountTransaction = accountTransactionRepository.save(accountTransactionDto.getAccountTransaction(accountType, accountBalance));
            return new AccountTransactionDto(accountTransaction);
        } catch (Exception e) {
            throw new RuntimeException("unable to save to the DB", e);
        }
    }

    @Override
    public AccountTransactionDto getBalanceByMnemonic(Long memberID, String mnemonic) {
        try {
            return accountTransactionRepository.getTransactionByMnemonic(memberID);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
