package za.ac.nwu.ac.translator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountBalanceRepository;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class AccountBalanceTranslatorImplTest {

    @Mock
    private AccountBalanceRepository balanceRepo;

    @InjectMocks
    private AccountBalanceTranslatorImpl translator;

    @Mock
    private AccountTypeRepository accountTypeRepo;

    @Mock
    private AccountType accountType;

    @Before
    public void setUp() throws Exception {
        accountType = new AccountType();
    }

    @After
    public void tearDown() throws Exception {
        accountType = null;
    }

//    @Test
//    public void create() {
//        accountType = accountTypeRepo.getAccountTypeByMnemonic("MILES");
//        when(balanceRepo.save(any(AccountBalanceDto.class)))
//    }

    @Test
    public void getAccountBalanceByMnemonic() {
        accountType = accountTypeRepo.getAccountTypeByMnemonic("MILES");
        when(balanceRepo.getAccountBalanceDtoByMemberID(1L, accountType)).thenReturn(null);
        AccountBalanceDto result = translator.getAccountBalanceByMnemonic(1L, "MILES");
        assertNull(result);
        verify(balanceRepo).getAccountBalanceDtoByMemberID(1L, accountType);
    }
}