package za.ac.nwu.ac.translator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountTypeTranslatorImplTest {

    @Mock
    private AccountTypeRepository accountTypeRepo;

    @InjectMocks
    private AccountTypeTranslatorImpl translator;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void getAllAccountTypes() {
//    }

//    @Test
//    public void create() {
//    }

    @Test
    public void delete() {
        accountTypeRepo.deleteAccountTypeDtoByMnemonic("MILES");
        AccountType accountType = accountTypeRepo.getAccountTypeByMnemonic("MILES");
        assertNull(accountType);
        verify(accountTypeRepo, times(1)).deleteAccountTypeDtoByMnemonic("MILES");
    }

    @Test
    public void getAccountTypeDtoByMnemonic() {
        when(translator.getAccountTypeDtoByMnemonic("MILES")).thenReturn(null);
        AccountTypeDto result = accountTypeRepo.getAccountTypeDtoByMnemonic("MILES");
        assertNull(result);
        verify(accountTypeRepo).getAccountTypeDtoByMnemonic("MILES");
    }

    @Test
    public void update() {
        accountTypeRepo.updateAccountTypeDtoByMnemonic("MILES", "Plays", LocalDate.now());
        AccountType accountType = accountTypeRepo.getAccountTypeByMnemonic("MILES");
        assertNull(accountType);
        verify(accountTypeRepo, times(1)).updateAccountTypeDtoByMnemonic("MILES", "Plays", LocalDate.now());
    }
}