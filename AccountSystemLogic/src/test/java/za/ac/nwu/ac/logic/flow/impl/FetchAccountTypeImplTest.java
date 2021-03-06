package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountTypeImplTest {

    private FetchAccountTypeImpl classToTest;

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private FetchAccountTypeImpl flow;

    @Before
    public void setUp() throws Exception {
        classToTest = new FetchAccountTypeImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

    @Test
    public void getAllAccountTypes() {
        when(translator.getAllAccountTypes()).thenReturn(null);
        List<AccountTypeDto> result = flow.getAllAccountTypes();
        assertNull(result);
        verify(translator).getAllAccountTypes();
    }

    @Test
    public void getAccountTypeByMnemonic() {
        when(translator.getAccountTypeDtoByMnemonic("MILES")).thenReturn(null);
        AccountTypeDto result = flow.getAccountTypeByMnemonic("MILES");
        assertNull(result);
        verify(translator).getAccountTypeDtoByMnemonic("MILES");
    }
}