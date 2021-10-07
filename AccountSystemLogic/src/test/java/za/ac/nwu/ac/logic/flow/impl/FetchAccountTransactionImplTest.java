package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountTransactionImplTest {

    @Mock
    private AccountTransactionTranslator translator;

    @InjectMocks
    private FetchAccountTransactionImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBalanceByMnemonic() {
        when(translator.getBalanceByMnemonic(1L, "MILES")).thenReturn(null);
        AccountTransactionDto result = flow.getBalanceByMnemonic(1L, "MILES");
        assertNull(result);
        verify(translator).getBalanceByMnemonic(1L, "MILES");
    }
}