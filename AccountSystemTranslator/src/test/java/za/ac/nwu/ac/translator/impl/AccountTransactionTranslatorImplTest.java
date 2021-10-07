package za.ac.nwu.ac.translator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountBalance;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountBalanceRepository;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

//@RunWith(MockitoJUnitRunner.class)
public class AccountTransactionTranslatorImplTest {

//    @Mock
//    private AccountTransactionRepository transactionRepo;
//
//    @InjectMocks
//    private AccountTransactionTranslatorImpl translator;
//
//    @Mock
//    private AccountTypeRepository accountTypeRepo;
//
//    @Mock
//    private AccountBalanceRepository balanceRepo;
//
//    @Mock
//    private AccountType accountType;
//
//    @Mock
//    private AccountBalance accountBalance;

    @Before
    public void setUp() throws Exception {
//        accountType = new AccountType();
//        accountBalance = new AccountBalance();
    }

    @After
    public void tearDown() throws Exception {
//        accountType = null;
//        accountBalance = null;
    }

//    @Test
//    public void create() {
//        accountType = accountTypeRepo.getAccountTypeByMnemonic("MILES");
//        accountBalance = balanceRepo.getAccountBalanceByMemberID(1L, accountType);
//        AccountTransactionDto result = translator.create("MILES", 1L, 200L, LocalDate.now());
//        assertNull(result);
//        AccountTransaction accountTransaction = new AccountTransaction(accountType, accountBalance, 200L, LocalDate.now());
//        assertNull(accountTransaction);
//    }
}